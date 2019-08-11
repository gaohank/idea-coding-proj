package cn.gaohank.idea.hadoop.common

import cn.gaohank.idea.hadoop.common.HdfsIO._
import cn.gaohank.idea.meta.ThingMeta
import org.apache.spark.{SparkConf, SparkContext}

object WriteData {
  def main(args: Array[String]): Unit = {
    require(args.length == 1, "output")
    val Array(output) = args
    val conf =  new SparkConf().setAppName(this.getClass.getSimpleName).setIfMissing("spark.master", "local")
    conf.setIfMissing("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    val sc = new SparkContext(conf)
    val meta1 = new ThingMeta()
    meta1.name = "hank"
    meta1.area = "西安"
    val meta2 = new ThingMeta()
    meta2.name = "james"
    meta2.area = "北京"
    val metaRdd = sc.parallelize(Array(meta1, meta2))
    metaRdd.saveAsSequenceFile(output)
  }
}
