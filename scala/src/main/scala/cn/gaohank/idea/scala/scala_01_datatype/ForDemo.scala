package cn.gaohank.idea.scala.scala_01_datatype

object ForDemo {
  def main(args: Array[String]): Unit = {
    // 2 4
    for (i <- List(1, 2, 3, 4, 5, 6, 7)
         if i % 2 == 0
         if i < 6) {
      println(i)
    }

    // 大括号中用于保存变量和条件,循环中的 yield 会把当前的元素记下来，保存在集合中，循环结束后将返回该集合
    // List((hank,1), (hank,2), (hank,3), (bob,1), (bob,2), (bob,3), (james,1), (james,2), (james,3))
    val tuples = for { i <- List("hank", "bob", "james"); j <- List(1, 2, 3) } yield
      (i, j)
    println(tuples)
  }
}
