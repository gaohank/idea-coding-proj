package cn.gaohank.idea.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * 在bash上开启端口：8888
  * 通过nc输入日志内容
  * 输入的内容为：
  * 1 james
  * 2 andy
  */
object BlackList {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf()
            .setAppName(this.getClass.getSimpleName)
            .setIfMissing("spark.master", "local[2]")
        val spark = SparkSession.builder().config(conf).getOrCreate()
        val ssc = new StreamingContext(spark.sparkContext, Seconds(5))

        val black = List(("james", true))
        val blackRdd = spark.sparkContext.parallelize(black)
        val listen = ssc.socketTextStream("127.0.0.1", 9999)
        // 分隔为：(hank, (84, hank))
        val ds = listen.map(v => (v.split(" ")(1), v))
        // DStream离散流RDD->RDD，必须通过transform才能join
        val endDs = ds.transform { v =>
            // RDD[(String, String)]和RDD[(String, Boolean)]做Join
            val joinRdd = v.leftOuterJoin(blackRdd)
            println(joinRdd.collect().toBuffer)
            joinRdd.map(_._2).filter {
                case (_, Some(_)) => false
                case (_, None) => true
            }
                .map(_._1)
        }
        endDs.print()
        ssc.start()
        ssc.awaitTermination()
    }
}
