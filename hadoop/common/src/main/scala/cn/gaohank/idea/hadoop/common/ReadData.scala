package cn.gaohank.idea.hadoop.common

import org.apache.spark.{SparkConf, SparkContext}
import cn.gaohank.idea.hadoop.common.HdfsIO._
import cn.gaohank.idea.meta.ThingMeta

object ReadData {
  def main(args: Array[String]): Unit = {
    require(args.length == 1, "input")
    val Array(input) = args
    val conf = new SparkConf()
      .setAppName(this.getClass.getSimpleName)
      .setIfMissing("spark.master", "local")
    conf.setIfMissing("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    val sc = new SparkContext(conf)
    val metaRdd = sc.thriftSequenceFile(input, classOf[ThingMeta])
    metaRdd.foreach(println)
  }
}
