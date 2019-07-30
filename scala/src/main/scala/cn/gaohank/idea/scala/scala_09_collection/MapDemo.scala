package cn.gaohank.idea.scala.scala_09_collection

import scala.collection.mutable

object MapDemo {
  def main(args: Array[String]): Unit = {
    // 定长map，不可修改
    val scores = Map("hank" -> 85, "james" -> 90, "stan" -> 92)
    // Map(hank -> 85, james -> 90, stan -> 92)
    println(scores)
    // 90
    println(scores("james"))
    // 60
    println(scores.getOrElse("bob", 60))

    // 可变map
    val ages = mutable.Map("tom" -> 19, "hank" -> 20, "james" -> 30)
    ages.put("bob", 15)
    ages -= "james"
    // Map(hank -> 20, bob -> 15, tom -> 19)
    println(ages)
    ages("hank") = 28
    println(ages)
  }
}
