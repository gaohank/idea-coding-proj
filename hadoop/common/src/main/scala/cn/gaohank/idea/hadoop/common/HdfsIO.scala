package cn.gaohank.idea.hadoop.common

import java.io.{ByteArrayOutputStream, InputStream}

import cn.gaohank.idea.meta.ThingMeta
import org.apache.hadoop.io.compress.{CompressionCodec, DefaultCodec}
import org.apache.hadoop.io.{BytesWritable, Writable}
import org.apache.hadoop.mapred.{JobConf, SequenceFileOutputFormat}
import org.apache.spark.rdd.RDD
import org.apache.thrift.TBase
import org.apache.thrift.protocol.{TBinaryProtocol, TCompactProtocol}
import org.apache.thrift.transport.TIOStreamTransport
import org.slf4j.{Logger, LoggerFactory}

import scala.reflect.ClassTag

object HdfsIO {
  private val logger: Logger = LoggerFactory.getLogger(this.getClass.getSimpleName)

  def serCompactThrift[T <: TBase[_, _] : ClassTag](info: T): Array[Byte] = {
    val out = new ByteArrayOutputStream()
    val transport = new TIOStreamTransport(out)
    val protocol = new TCompactProtocol(transport)
    info.write(protocol)
    out.toByteArray
  }

  def deCompactThrift[T <: TBase[_, _] : ClassTag](info: T, in: InputStream): T = {
    val transport = new TIOStreamTransport(in)
    val protocol = new TCompactProtocol(transport)
    info.read(protocol)
    info
  }

  def serBinaryThrift[T <: TBase[_, _] : ClassTag](info: T): Array[Byte] = {
    val out = new ByteArrayOutputStream()
    val transport = new TIOStreamTransport(out)
    val protocol = new TBinaryProtocol(transport)
    info.write(protocol)
    out.toByteArray
  }

  def saveTest(rdd: RDD[ThingMeta], output: String, protocal: String = "compact"): Unit = {
    rdd.map {v =>
      val bytes =
        protocal match {
          case "compact" => serCompactThrift(v)
          case "binary" => serBinaryThrift(v)
          case _ => throw new IllegalArgumentException(s"unsupported protocal: $protocal")
        }
      new BytesWritable(bytes)
    }.saveAsTextFile(output)
  }

  /**
    * 为thrift对象的RDD类增加保存为paruqet/sequence文件的方法
    */
  implicit class RDDThriftOutputWrapper[T <: TBase[_, _] : ClassTag](val rdd: RDD[T]) {
    def serCompact(info: T): Array[Byte] = {
      val out = new ByteArrayOutputStream()
      val transport = new TIOStreamTransport(out)
      val protocol = new TCompactProtocol(transport)
      info.write(protocol)
      out.toByteArray
    }

    def serBinary(info: T): Array[Byte] = {
      val out = new ByteArrayOutputStream()
      val transport = new TIOStreamTransport(out)
      val protocol = new TBinaryProtocol(transport)
      info.write(protocol)
      out.toByteArray
    }

    def saveAsSequenceFile(output: String,
                           codec: Class[_ <: CompressionCodec] = classOf[DefaultCodec],
                           protocal: String = "compact"): Unit = {

      val format = classOf[SequenceFileOutputFormat[Writable, Writable]]
      val jobConf = new JobConf(rdd.context.hadoopConfiguration)

      rdd
        .map { v =>
          val bytes =
            protocal match {
              case "compact" => serCompact(v)
              case "binary" => serBinary(v)
              case _ => throw new IllegalArgumentException(s"unsupported protocal: $protocal")
            }
          (new BytesWritable(), new BytesWritable(bytes))
        }
        .saveAsHadoopFile(
          output,
          classOf[BytesWritable],
          classOf[BytesWritable],
          format
//          jobConf,
//          Some(codec)
        )
    }
  }
}
