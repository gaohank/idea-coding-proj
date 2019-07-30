package cn.gaohank.idea.scala.scala_09_collection

import scala.collection.mutable.ArrayBuffer

object ArrayBufferDemo {
  def main(args: Array[String]): Unit = {
    // 变长数组
    val buf = ArrayBuffer[Int]()
    buf += 1
    println(buf)
    buf += (5, 3, 8)
    println(buf)
    buf ++= Array(8, 9)
    println(buf)
    // ArrayBuffer(1, 5, 3, 8, 8, 9, 6, 7)
    buf ++= ArrayBuffer(6, 7)
    println(buf)
    // 插入  ArrayBuffer(3, 3, 3, 1, 5, 3, 8, 8, 9, 6, 7)
    buf.insert(0, 3, 3, 3)
    println(buf)
    // 删除 ArrayBuffer(3, 1, 5, 3, 8, 8, 9, 6, 7)
    buf.remove(0, 2)
    println(buf)
  }
}
