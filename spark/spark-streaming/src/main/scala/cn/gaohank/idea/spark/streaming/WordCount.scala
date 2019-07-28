package cn.gaohank.idea.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}

object WordCount {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf()
            .setAppName(this.getClass.getSimpleName)
            .setIfMissing("spark.master", "local[2]") // 大于1，需要有接收任务的线程
        val spark = SparkSession.builder().config(conf).getOrCreate()
        // 设置多少秒形成一个批次
        val ssc = new StreamingContext(spark.sparkContext, Seconds(3))
        val ds = ssc.socketTextStream("127.0.0.1", 9999)
        val res = ds.flatMap(_.split(" ")).map((_, 1))
        ds.print()
        res.print()

        ssc.start()
        ssc.awaitTermination()
    }
}
