package cn.gaohank.idea.scala.scala_10_match_case

import scala.util.Random

object CaseDemo {
  def main(args: Array[String]): Unit = {
    val names = Array("hank", "bob", "james")
    // 获得随机的名字
    val name = names(Random.nextInt(names.length))

    name match {
      case "hank"  => println("good")
      case "bob"   => println("well")
      case "james" => println("bad")
      case _       => println("not known")
    }

    // Map(h -> hank, o -> other)
    val namemap = names.map {
      case x if x.contains("k") => (x.head, x)
      case _                    => ('o', "other")
    }.toMap
    println(namemap)
  }
}
