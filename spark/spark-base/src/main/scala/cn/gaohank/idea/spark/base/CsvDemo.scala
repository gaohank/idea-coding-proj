package cn.gaohank.idea.spark.base

import java.io.StringReader

import com.opencsv.CSVReader
import org.apache.spark.{SparkConf, SparkContext}

object CsvDemo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CsvTest").setMaster("local")
    val sc = new SparkContext(conf)
    val csvRdd = sc.wholeTextFiles(CsvDemo.getClass.getClassLoader.getResource("test.csv").getPath)
    csvRdd.flatMap {
      case (_, v) =>
        val reader = new CSVReader(new StringReader(v))
        scala.collection.JavaConversions.asScalaIterator(reader.readAll().iterator())
    }
      .flatMap(v => v.toList)
      .foreach(v => println(s"value is : ${v.replace("\n", "")}"))
  }
}
