package cn.gaohank.idea.spark.base

import org.apache.spark.{SparkConf, SparkContext}

object IpLocation {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("IpLocation").setMaster("local[1]")
        val sc = new SparkContext(conf)
        val ipRdd = sc.textFile(IpLocation.getClass.getClassLoader.getResource("ip.txt").getPath)
        println(ipRdd.count())
        sc.stop()
    }
}
