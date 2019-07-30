package cn.gaohank.idea.scala.scala_03_class

object OptionDemo {
  def main(args: Array[String]): Unit = {
    // true
    println(Option("\"action\":\"query\"").exists(_.contains("query")))

    val test: Option[String] = None
    val str = test.map(v => v).map(v => v + "123").getOrElse("helloworld")
    // helloworld
    println(str)
    println(test.isDefined)
    println(test.isEmpty)
    println(None.isEmpty)
    println(None.isDefined)
  }
}
