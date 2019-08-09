package cn.gaohank.idea.hadoop.common

import cn.gaohank.idea.meta.ThingMeta
import org.apache.spark.{SparkConf, SparkContext}
import cn.gaohank.idea.hadoop.common.HdfsIO._

object WriteData {
  def main(args: Array[String]): Unit = {
    require(args.length == 1, "output")
    val Array(output) = args
    val conf =  new SparkConf().setAppName(this.getClass.getSimpleName).setIfMissing("spark.master", "local")
    val sc = new SparkContext(conf)
    val meta1 = new ThingMeta()
    meta1.name = "hank"
    meta1.area = "西安"
    val meta2 = new ThingMeta()
    meta2.name = "james"
    meta2.area = "北京"
    val metaRdd = sc.parallelize(Array(meta1, meta2))
//    val metaRdd = sc.parallelize(Array(
//      (new BytesWritable(), new BytesWritable(meta1.toString.getBytes())),
//      (new BytesWritable(), new BytesWritable(meta2.toString.getBytes()))
//    ))
//    var rdd1 = sc.parallelize(Array(("A",2),("A",1),("B",6),("B",3),("B",7)))

//    metaRdd.saveAsHadoopFile(
//      output,
//      classOf[BytesWritable],
//      classOf[BytesWritable],
//      classOf[SequenceFileOutputFormat[Writable, Writable]]
//    )
    metaRdd.saveAsSequenceFile(output)
  }
}
