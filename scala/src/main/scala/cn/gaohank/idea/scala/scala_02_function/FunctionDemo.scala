package cn.gaohank.idea.scala.scala_02_function

object FunctionDemo {
  def main(args: Array[String]): Unit = {
    // val 函数名 = 函数参数列表 => 函数体
    val func = (x: Int, y: Int) => x + y
    println(func(4, 7))

    // 匿名函数
    val range = 1 to 10
    println(range.map(_ * 10))

    // 偏函数
    // 偏函数中最常见的组合方法为orElse、andThen与compose
    val ints = List(1, 2, 3, 4)
    val pf: PartialFunction[Int, String] = {
      case i if i % 2 == 0 => "even"
    }
    val tf: Int => String = pf.orElse { case _ => "odd" }
    println(ints.map(tf))

    ints
      .map {
        case 2 => "two"
        case _ => "other"
      }
      .foreach(println(_))
  }
}
