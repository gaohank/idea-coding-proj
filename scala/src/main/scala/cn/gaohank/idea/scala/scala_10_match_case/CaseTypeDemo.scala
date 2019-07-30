package cn.gaohank.idea.scala.scala_10_match_case

import scala.util.Random

object CaseTypeDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(1.3, 2, "nihao", null)
    // ArrayBuffer(1.3, 2, nihao, null)
    println(arr.toBuffer)
    // 4
    println(arr.length)
    val m = arr(Random.nextInt(4))

    m match {
      case a: String => println("String" + a)
      case b: Int    => println("Int :" + b)
      case c: Double => println("Double :" + c)
      case _         => println("none")
    }
  }
}
