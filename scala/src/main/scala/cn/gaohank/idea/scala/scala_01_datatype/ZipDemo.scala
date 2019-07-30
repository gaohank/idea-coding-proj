package cn.gaohank.idea.scala.scala_01_datatype

object ZipDemo {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    val list2 = List('a', 'b')
    // List((1, a), (2, b))
    println(list1.zip(list2))
    // List(((1, a), 0), ((2, b), 1))
    println(list1.zip(list2).zipWithIndex)
  }
}
