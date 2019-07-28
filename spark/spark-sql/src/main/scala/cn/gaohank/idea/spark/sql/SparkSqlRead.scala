package cn.gaohank.idea.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkSqlRead {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName(this.getClass.getSimpleName).setIfMissing("spark.master", "local")
        val spark = SparkSession.builder().config(conf).getOrCreate()

        val studentRdd = spark.sparkContext
            .parallelize(Array("1 zhangsan 18", "2 lisi 22", "3 wangwu 66"))
            .map(_.split(" "))
            .map(v => StudentSchema(v(0).toInt, v(1), v(2).toInt))

        import spark.sqlContext.implicits._
        val studentDF = studentRdd.toDF()
        val rowRdd = studentDF.where(studentDF("name").isNotNull and studentDF("age") > 20)
            .select(studentDF("name"), studentDF("age"))
            .rdd

        studentDF.show()
        rowRdd.map(v => v.toString()).foreach(v => print(v))
        rowRdd.foreach(v => println(v.getAs[String]("name")))
    }
}
