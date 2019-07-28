package cn.gaohank.idea.spark.sql

import java.util.Properties

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object MysqlRead {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName(this.getClass.getSimpleName).setIfMissing("spark.master", "local")
        val spark = SparkSession.builder().config(conf).getOrCreate()
        val properties = new Properties()
        properties.setProperty("driver", "com.mysql.jdbc.Driver")
        properties.setProperty("user", "root")
        properties.setProperty("password", "root")
        val studentDF = spark.read.jdbc("jdbc:mysql://localhost:3306/spark", "students", properties)
//        studentDF.write.json("./json/spark-sql-read")
        studentDF.show()
    }
}
