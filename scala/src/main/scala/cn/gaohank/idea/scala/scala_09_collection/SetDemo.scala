package cn.gaohank.idea.scala.scala_09_collection

import scala.collection.immutable.HashSet
import scala.collection.mutable

object SetDemo {
  def main(args: Array[String]): Unit = {
    val set1 = new HashSet[Int]()
    val set2 = set1 + 4
    // Set(4)
    println(set2)
    val set3 = set2 ++ Set(5, 6, 7)
    // Set(5, 6, 7, 4)
    println(set3)
    // Set(5, 1, 6, 2, 7, 3, 4)
    val set4 = Set(1, 2, 3) ++ set3
    println(set4)

    val set5 = new mutable.HashSet[Int]()
    set5 += 5
    set5.add(4)
    set5 ++= Set(1, 3, 5)
    // Set(1, 5, 3, 4)
    println(set5)
  }
}
