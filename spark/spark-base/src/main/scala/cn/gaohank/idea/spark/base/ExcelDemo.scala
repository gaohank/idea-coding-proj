package cn.gaohank.idea.spark.base

import java.io.FileOutputStream

import org.apache.poi.hssf.usermodel.{HSSFRow, HSSFSheet, HSSFWorkbook}
import org.apache.spark.{SparkConf, SparkContext}

case class Politic(keyword: String,
                   subClass: String,
                   word: String,
                   blackList: String)

case class Pron(keyword: String,
                subClass: String)

case class Mg(keyword: String, subClass: String = "无")

// HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls；
// XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx；
// SXSSFworkbook:当数据量超出65536条后，在使用HSSFWorkbook或XSSFWorkbook，程序会报OutOfMemoryError：Javaheap space;内存溢出错误；

object ExcelDemo {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("Txt2Excel").setMaster("local")
        val sc = new SparkContext(conf)

        val inputPronRdd = sc.textFile(ExcelDemo.getClass.getClassLoader.getResource("pron.txt").getPath)
        val inputMgRdd = sc.textFile(ExcelDemo.getClass.getClassLoader.getResource("mg.txt").getPath)

        val pronRdd = inputPronRdd.map(v => {
            val strings = v.split("\t")
            Pron(strings(0), strings(1))
        })
            .keyBy(_.keyword)
            .map(v => v)
            .reduceByKey {
                case (a, _) => a
            }
            .repartition(1)
            .values

        val mgRdd = inputMgRdd.repartition(1).distinct().map(v => Mg(keyword = v))

        val wb = new HSSFWorkbook()
        val sheet = wb.createSheet("politic")
        var rowNum = 0

        val prons = pronRdd.collect()
        for (elem <- prons) {
            val row: HSSFRow = sheet.createRow(rowNum)
            row.createCell(0).setCellValue(elem.keyword)
            row.createCell(1).setCellValue(elem.subClass)
            rowNum += 1
        }

        val mgs = mgRdd.collect()
        for (elem <- mgs) {
            val row: HSSFRow = sheet.createRow(rowNum)
            row.createCell(0).setCellValue(elem.keyword)
            row.createCell(1).setCellValue(elem.subClass)
            rowNum += 1
        }

        // 保存包项目路径下
        val stream = new FileOutputStream("./excel写数据.xls")
        wb.write(stream)
        stream.close()
    }
}
