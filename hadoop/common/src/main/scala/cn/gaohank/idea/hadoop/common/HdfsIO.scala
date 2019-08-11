package cn.gaohank.idea.hadoop.common

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import org.apache.hadoop.io.compress.{CompressionCodec, DefaultCodec}
import org.apache.hadoop.io.{BytesWritable, Writable}
import org.apache.hadoop.mapred.{JobConf, SequenceFileOutputFormat}
import org.apache.hadoop.mapreduce.Job
import org.apache.parquet.hadoop.metadata.CompressionCodecName
import org.apache.parquet.hadoop.thrift.{ParquetThriftInputFormat, ParquetThriftOutputFormat, ThriftReadSupport}
import org.apache.parquet.hadoop.{ParquetInputFormat, ParquetOutputFormat}
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.thrift.TBase
import org.apache.thrift.protocol.{TBinaryProtocol, TCompactProtocol}
import org.apache.thrift.transport.TIOStreamTransport
import org.slf4j.{Logger, LoggerFactory}

import scala.reflect.{ClassTag, classTag}

object HdfsIO {
  private val logger: Logger =
    LoggerFactory.getLogger(this.getClass.getSimpleName)

  def serCompactThrift[T <: TBase[_, _]: ClassTag](info: T): Array[Byte] = {
    val out = new ByteArrayOutputStream()
    val transport = new TIOStreamTransport(out)
    val protocol = new TCompactProtocol(transport)
    info.write(protocol)
    out.toByteArray
  }

  def deCompactThrift[T <: TBase[_, _]: ClassTag](info: T, bytes: Array[Byte]): T = {
    val transport = new TIOStreamTransport(new ByteArrayInputStream(bytes))
    val protocol = new TCompactProtocol(transport)
    info.read(protocol)
    info
  }

  def serBinaryThrift[T <: TBase[_, _]: ClassTag](info: T): Array[Byte] = {
    val out = new ByteArrayOutputStream()
    val transport = new TIOStreamTransport(out)
    val protocol = new TBinaryProtocol(transport)
    info.write(protocol)
    out.toByteArray
  }

  def deBinaryThrift[T <: TBase[_, _]: ClassTag](info: T, bytes: Array[Byte]): T = {
    val transport = new TIOStreamTransport(new ByteArrayInputStream(bytes))
    val protocol = new TBinaryProtocol(transport)
    info.read(protocol)
    info
  }

  /**
    * 为thrift对象的RDD类增加保存为paruqet/sequence文件的方法
    */
  implicit class RDDThriftOutputWrapper[T <: TBase[_, _] : ClassTag](val rdd: RDD[T]) extends Serializable {
    def saveAsSequenceFile(output: String,
                           codec: Class[_ <: CompressionCodec] = classOf[DefaultCodec],
                           protocal: String = "compact"): Unit = {

      val format = classOf[SequenceFileOutputFormat[Writable, Writable]]
      val jobConf = new JobConf(rdd.context.hadoopConfiguration)
      rdd
        .map { v =>
          val bytes =
            protocal match {
              case "compact" => serCompactThrift(v)
              case "binary" => serBinaryThrift(v)
              case _ => throw new IllegalArgumentException(s"unsupported protocal: $protocal")
            }
          (new BytesWritable(), new BytesWritable(bytes))
        }
        .saveAsHadoopFile(
          output,
          classOf[BytesWritable],
          classOf[BytesWritable],
          format,
          jobConf,
          Some(codec)
        )
    }

    def saveAsParquetFile(output: String,
                          compress: CompressionCodecName = CompressionCodecName.SNAPPY,
                          enableDictionary: Boolean = true): Unit = {
      val job = Job.getInstance(rdd.sparkContext.hadoopConfiguration)
      val beanClass = classTag[T].runtimeClass.asInstanceOf[Class[T]]
      ParquetThriftOutputFormat.setThriftClass(job, beanClass)
      ParquetOutputFormat.setWriteSupportClass(job, beanClass)
      ParquetOutputFormat.setCompression(job, compress)
      ParquetOutputFormat.setEnableDictionary(job, enableDictionary)
      rdd
        .map(o => (null, o))
        .saveAsNewAPIHadoopFile(
          output,
          classOf[Void],
          beanClass,
          classOf[ParquetThriftOutputFormat[T]],
          job.getConfiguration
        )
    }
  }

  /**
    * 为SparkConetxt配上thriftParquetFile方法，直接加载parquet文件为thrift对象RDD
    */
  implicit class SparkContextThriftFileWrapper(val sc: SparkContext) {
    def thriftSequenceFile[T <: TBase[_, _]: ClassTag](path: String,
                           thriftClass: Class[T],
                           protocal: String = "compact"): RDD[T] = {
      sc.sequenceFile[Array[Byte], Array[Byte]](path)
        .mapPartitions { it =>
          for ((_, v) <- it) yield {
            val o = thriftClass.newInstance
            protocal match {
              case "compact" => deCompactThrift(o, v)
              case "binary"  => deBinaryThrift(o, v)
              case _ => new IllegalArgumentException(s"unsupported protocal: $protocal")
            }
            o
          }
        }
    }

    def thriftParquetFile[T <: TBase[_, _]: ClassTag](path: String,
                                                      thriftClass: Class[T],
                                                      columnFilter: String = "",
                                                      forceMatch: Boolean = false): RDD[T] = {

      val jobConf = new JobConf(sc.hadoopConfiguration)
      if (columnFilter != "") {
        jobConf.set(ThriftReadSupport.THRIFT_COLUMN_FILTER_KEY, columnFilter)
      }

      ParquetThriftInputFormat.setThriftClass(jobConf, thriftClass)
      ParquetInputFormat.setReadSupportClass(jobConf, classOf[ThriftReadSupport[T]])
      val rdd =
        sc.newAPIHadoopFile(
          path,
          classOf[ParquetThriftInputFormat[T]],
          classOf[Void],
          thriftClass,
          jobConf
        )
      rdd.map { case (void, obj) => obj }
    }
  }
}
