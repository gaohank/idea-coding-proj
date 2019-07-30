package cn.gaohank.idea.scala.scala_10_match_case

object MatchDemo {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 3, 5)
    // 3 5
    arr match {
      case Array(1, x, y) => println(x + " " + y)
      case Array(0)       => println("只有一个0")
      case Array(1, _*)   => println("1和其他")
      case _              => println("其他")
    }

    // x:1.3 y:hello
    val tup = (1, 1.3, "hello")
    tup match {
      case (1, x, y)     => println(s"x:$x y:$y")
      case (_, 9, "aaa") => println("123")
      case _             => println("qita")
    }

    // 除了0还有其他的List(2, 4, 5)
    val list = List(0, 2, 4, 5)
    list match {
      case 0 :: Nil      => println("只有一个0")
      case x :: y :: Nil => println(s"x: $x y:$y")
      case 0 :: tail     => println("除了0还有其他的" + tail)
    }
  }
}
