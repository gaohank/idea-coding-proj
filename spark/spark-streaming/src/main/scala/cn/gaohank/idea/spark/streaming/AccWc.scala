package cn.gaohank.idea.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}

object AccWc {
    // 当前批次某个单词出现的次数
    // Option[Int]：以前的累加值
    val updateFunc: Iterator[(String, Seq[Int], Option[Int])] =>
        Iterator[(String, Int)] = (iterator: Iterator[(String, Seq[Int], Option[Int])]) => {
        iterator.flatMap {
            // Some代表可以取到值
            case (x, y, z) => Some(y.sum + z.getOrElse(0)).map(m => (x, m))
        }
    }

    val updateFunc1: Iterator[(String, Seq[Int], Option[Int])] =>
        Iterator[(String, Int)] = (iterator: Iterator[(String, Seq[Int], Option[Int])]) => {
        iterator.flatMap(it => Some(it._2.sum + it._3.getOrElse(0)).map(x => (it._1, x)))
    }

    def main(args: Array[String]): Unit = {
        val conf = new SparkConf()
            .setAppName(this.getClass.getSimpleName)
            .setIfMissing("spark.master", "local[2]")
        val spark = SparkSession.builder().config(conf).getOrCreate()
        val sc = spark.sparkContext

        // 实时计算一定要做CheckPoint
        sc.setCheckpointDir("/tmp/AccWcCheckPoint")
        val ssc = new StreamingContext(spark.sparkContext, Seconds(5))
        val listen = ssc.socketTextStream("127.0.0.1", 9999)
        val res = listen.flatMap(_.split(" ")).map((_, 1))

        ssc.start()
        ssc.awaitTermination()
    }
}
