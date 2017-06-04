package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/5/8.
  */
object MapComprehension {
  val xs = Seq(Seq("a", "b", "c"), Seq("d", "e", "f"), Seq("g", "h"), Seq("i", "j", "k"))

  def main(args: Array[String]): Unit = {
    val ys = for (Seq(x, y, z) <- xs) yield x + y + z
//    val zs = xs map { case (x, y, z) => x + y + z}
  }


}
