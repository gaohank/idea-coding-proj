package cn.gaohank.idea.scala.scala_14_implicit

/**
  * Created by Administrator on 2017/11/12.
  */
// TYPE
object Food {
  implicit val food: String = "banana"
  implicit val num: Int = 84
}
object ImplicitDemo {
  def eat()(implicit food: String = "chicken"): Unit = {
    println(s"$food delicious")
  }

  def main(args: Array[String]): Unit = {
    eat()
    import Food._
    eat()
    eat()("apple")
  }
}

// def 方法要求我们传入一个隐式参数，一旦把门面倒进来，他就会在门面中找类型一致的
