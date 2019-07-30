package cn.gaohank.idea.scala.scala_09_collection

object SeqDemo {
  def getSeq(data: Option[String]): Seq[(String, String)] =
    data.map("ci" -> _).toSeq

  def main(args: Array[String]): Unit = {
    val ci = Option.empty[String]
    val seq = ci.map(v => v).map("ci" -> _).map(v => v).toSeq
    println(seq)
    println(seq.isEmpty)
  }
}
