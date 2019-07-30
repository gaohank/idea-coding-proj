package cn.gaohank.idea.scala.scala_06_trait

trait Listen {
  val name: String
  def listen(): Unit = {
    println("You friend " + name + " is listening")
  }
}

trait Read {
  val name: String
  def read(): Unit = {
    println("You friend " + name + " is reading")
  }
}

trait Speak {
  val name: String
  def speak(): Unit = {
    println("You friend " + name + " is speaking.")
  }
}

class Human(val name: String) {
  def listen(): Unit = {
    println(name + " is listening.")
  }
}

class Animal(val name: String) {}

class Cat(val name: String) extends Speak with Listen with Read {
  override def toString: String = getClass.getName + " hello " + name + "! "
}

object TraitDemo {
  def main(args: Array[String]) {
//        val f1 = new Listen();//java 接口很像 不能直接够造
//        val h1 = new Human("gaga")
//        h1.listen()

    //这样scat就是Friend了
    val scat = new Cat("hello kitty")
    scat.listen()
    scat.speak()
    scat.read()
    println(scat)
  }
}
