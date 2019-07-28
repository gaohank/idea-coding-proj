package cn.gaohank.idea.spark.sql

import java.util.Properties

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object MysqlWrite {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName(this.getClass.getSimpleName).setIfMissing("spark.master", "local")
        val spark = SparkSession.builder().config(conf).getOrCreate()

        val studentRdd = spark.sparkContext
            .parallelize(Array("1 zhangsan 18", "2 lisi 22", "3 wangwu 66"))
            .map(_.split(" "))
            .map(v => StudentSchema(v(0).toInt, v(1), v(2).toInt))

        import spark.sqlContext.implicits._
        val studentDF = studentRdd.toDF()

        // 设置mysql的配置
        val prop = new Properties()
        prop.put("user", "root")
        prop.put("password", "root")

        // 将数据追加到mysql数据库
        // 需要安装链接mysql的驱动包
        Class.forName("com.mysql.jdbc.Driver")
        studentDF.write.mode("append").jdbc("jdbc:mysql://localhost:3306/spark", "spark.students", prop)
        spark.sparkContext.stop()
    }
}
