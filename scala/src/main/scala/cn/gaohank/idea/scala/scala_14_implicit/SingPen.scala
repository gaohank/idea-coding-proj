package cn.gaohank.idea.scala.scala_14_implicit

/**
  * Created by Administrator on 2017/11/12.
  */
class SingPen {
  def write(context: String): Unit = println(context)
}

object ImplicitContext {
  implicit val signPen: SingPen = new SingPen
}

object SingPen {
  def signForExam(name: String)(implicit singPen: SingPen): Unit = {
    singPen.write(name + "arrived")
  }

  def main(args: Array[String]): Unit = {
    import ImplicitContext._
    signForExam("tom")
    signForExam("bob")
  }
}
