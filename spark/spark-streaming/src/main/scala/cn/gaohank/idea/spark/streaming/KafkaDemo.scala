package cn.gaohank.idea.spark.streaming

import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{HashPartitioner, SparkConf}

object KafkaDemo {
  val updateFunc: Iterator[(String, Seq[Int], Option[Int])] => Iterator[(String, Int)] =
    (iter: Iterator[(String, Seq[Int], Option[Int])]) => {
      iter.flatMap(it =>
        Some(it._2.sum + it._3.getOrElse(0)).map(x => (it._1, x)))
    }

  def main(args: Array[String]): Unit = {
    val Array(zkQuorum, group, topics, numThreads) = args
    val conf = new SparkConf()
      .setAppName(this.getClass.getSimpleName)
      .setIfMissing("spark.master", "local[2]")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val sc = spark.sparkContext
    val ssc = new StreamingContext(sc, Seconds(5))

    sc.setCheckpointDir("./checkpoint")
    val topicMap = topics.split(",").map((_, numThreads.toInt)).toMap
    val ds = KafkaUtils.createStream(ssc,
                                     zkQuorum,
                                     group,
                                     topicMap,
                                     StorageLevel.MEMORY_AND_DISK)

    val words = ds.map(_._2).flatMap(_.split(" "))
    val res = words
      .map((_, 1))
      .updateStateByKey(updateFunc,
                        new HashPartitioner(sc.defaultParallelism),
                        rememberPartitioner = true)

    println(res)
    ssc.start()
    ssc.awaitTermination()
  }
}
