package cn.gaohank.idea.scala.scala_07_io

import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization._
import org.json4s.{Formats, NoTypeHints}

class Test(val names: List[String]) {

}

case class Person(name: String, age: Int)

object Json4s {
  implicit val formats: AnyRef with Formats = Serialization.formats(NoTypeHints)

  def main(args: Array[String]): Unit = {
    val test = new Test(List("hank", "james"))
    println(write(test))
    println(write(Person("hank", 29)))
  }
}
