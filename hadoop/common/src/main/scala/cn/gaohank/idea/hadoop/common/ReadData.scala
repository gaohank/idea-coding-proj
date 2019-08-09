package cn.gaohank.idea.hadoop.common

import java.io.{ByteArrayInputStream, FileInputStream}

import cn.gaohank.idea.meta.ThingMeta
import org.apache.spark.{SparkConf, SparkContext}
import cn.gaohank.idea.hadoop.common.HdfsIO._
import org.apache.hadoop.io.{ByteWritable, BytesWritable}

object ReadData {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WriteData").setMaster("local[1]")
    val sc = new SparkContext(conf)

//    val meta1 = new ThingMeta()
//    meta1.name = "hank"
//    meta1.area = "西安"
//    val bytes = serCompactThrift(meta1)
//
//    bytes.foreach(println)
//
//    val meta = deCompactThrift(new ThingMeta(), new ByteArrayInputStream(bytes))
//    print(meta)
      val str:String = "acef"
      val writable = new BytesWritable(str.getBytes())
      println(writable)
      val str1:String = "61 63 65 66"
      val bytes = new BytesWritable(str1.getBytes()).getBytes
    bytes.foreach(println)
    sc.textFile("d:/tmp/compact")
      .map(v => deCompactThrift(new ThingMeta(), new ByteArrayInputStream(v.getBytes)))
      .saveAsTextFile("")
  }
}
