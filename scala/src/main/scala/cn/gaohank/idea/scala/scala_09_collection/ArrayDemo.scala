package cn.gaohank.idea.scala.scala_09_collection

object ArrayDemo {
  def main(args: Array[String]): Unit = {
    val ints = new Array[Int](8)
    // 8
    println(ints.length)
    val ints2 = Array[Int](1, 2, 3) // Array(1, 2, 3)
    // 3
    println(ints2.length)

    // 012
    ints2.indices.foreach(print(_))
    println
    // 6
    println(ints2.sum)

    // ArrayBuffer(3, 2, 1)
    println(ints2.sortWith((a, b) => a > b).toBuffer)
    println(ints2.sortBy(+_).toBuffer)
    // ArrayBuffer(3, 2, 1)
    println(ints2.sortBy(-_).toBuffer)
  }
}
