package cn.gaohank.idea.scala.scala_01_datatype

object OptionDemo {
  def main(args: Array[String]): Unit = {
    val test: Option[String] = None
    val str = test.map(_ + "213").getOrElse("hello")
    println(str)
  }
}
