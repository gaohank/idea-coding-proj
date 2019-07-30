package cn.gaohank.idea.scala.scala_09_collection

import scala.collection.mutable.ListBuffer

/**
  * (1) :: 向队列的头部追加数据，创造新的列表。用法为 x::list,其中x为加入到头部的元素，无论x是列表与否，它都只将成为新生成列表的第一个元素，也就是说新生成的列表长度为list的长度＋1(btw, x::list等价于list.::(x))
  *
  * (2) :+和+: 两者的区别在于:+方法用于在尾部追加元素，+:方法用于在头部追加元素，和::很类似，但是::可以用于pattern match ，而+:则不行. 关于+:和:+,只要记住冒号永远靠近集合类型就OK了
  *
  * (3) ++ 该方法用于连接两个集合，list1++list2
  *
  * (4) ::: 该方法只能用于连接两个List类型的集合
  */
object ListDemo {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3)
    println(
      list.filter(v => v == 4) ::: List(123, 345) ::: list.filter(v => v == 5))
    println(list.head)
    println(list.tail)
    println(list(1))
    // List(0, 1, 2, 3)
    println(0 :: list)
    // List(0, 1, 2, 3)
    println(list.::(0))
    // List(List(5, 6, 7), 1, 2, 3)
    println(List(5, 6, 7) :: list)
    // List(1, 2, 3, 0)
    println(list :+ 0)
    // List(1, 2, 3, 5, 6, 7)
    println(list ++ Array(5, 6, 7))
    // List(1, 2, 3, 4, 5, 6)
    println(list ::: List(4, 5, 6))

    // 可变长List
    val ints = ListBuffer(1, 2, 3)
    ints += 4
    ints += 5
    // ListBuffer(1, 2, 3, 4, 5, 6)
    println(ints :+ 6)
    ints.insert(1, 10, 9)
    // ListBuffer(1, 10, 9, 2, 3, 4, 5)
    println(100 +: ints)
    ints.remove(4)
    println(ints)

    val nums = List(10, 6, 8, 9, 3, 1)
    val newNums = nums.sortBy(-_).headOption
    val max = nums.max
    println(newNums)
    println(max)
  }
}
