package cn.gaohank.idea.scala.scala_02_function

/**
  * Currying
  */
object CurryingDemo {
  def klh(x: Int)(y: Int): Int = x * y

  // def m(x: Int): Int => Int
  def m(x: Int): Int => Int = (y: Int) => x * y

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    // 15
    println(list.foldLeft(5)(_ + _))

    val res = klh(2)(3)
    // 6
    println(res)
    val a1 = klh(2)(_)
    val a2 = a1(3)
    // 6
    println(a2)

    val a3 = m(3)
    val a4 = a3(5)
    // 15
    println(a4)
  }
}
