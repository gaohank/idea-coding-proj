package cn.gaohank.idea.scala.scala_01_datatype

import org.scalatest.FunSuite

class StringDemoTest extends FunSuite {
    test("first test demo") {
        println("========================")
        println("my first test demo")
        println("========================")
        val name: String = null
        assert(Option(name) === Option.empty)

        val category = ""
        assert(category.isEmpty === true)
    }
}
