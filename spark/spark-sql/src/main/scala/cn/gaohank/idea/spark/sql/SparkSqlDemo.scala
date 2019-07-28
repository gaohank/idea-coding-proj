package cn.gaohank.idea.spark.sql

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

case class StudentSchema(id: Int, name: String, age: Int)

object SparkSqlDemo {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName(this.getClass.getSimpleName).setIfMissing("spark.master", "local")
        val spark = SparkSession.builder().config(conf).getOrCreate()
        val sc = spark.sparkContext

        import spark.sqlContext.implicits._
        
        val studentRdd = sc.parallelize(Array("1 zhangsan 18", "2 lisi 22", "3 wangwu 66")).map(_.split(" "))

        val studentDf = studentRdd.map(v => StudentSchema(v(0).toInt, v(1), v(2).toInt)).toDF()
        studentDf.select("name", "age").show()
        studentDf.select("name", "age").toJSON.show()

        studentDf.createOrReplaceTempView("student")
        val result = spark.sqlContext.sql("select * from student where age > 20 order by age desc")
        result.show()
    }
}
