package cn.gaohank.idea.scala.scala_01_datatype

object TupleDemo {
  def main(args: Array[String]): Unit = {
    val tuple = ((1, 2), (3, 4), (5, 6))
    println(tuple)
    // (1,2)
    println(tuple._1)
  }
}
