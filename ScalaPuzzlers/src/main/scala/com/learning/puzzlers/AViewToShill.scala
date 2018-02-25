package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/11/30.
  */
object AViewToShill {

  def process() = {
    val ints = Map("15" -> List(1, 2, 3, 4, 5))
    val intsIter1 = ints map { case (k, v) => (k, v.toIterator)}
    val intsIter2 = ints mapValues (_.toIterator)
    println(intsIter1("15").next(), intsIter1("15").next())
    println(intsIter2("15").next(), intsIter2("15").next())

    // amend it
    val strict = intsIter2.view.force
    println(strict("15").next(), strict("15").next())
  }

  def main(args: Array[String]): Unit = {
    process()
    val l = List(1, 2, 3, 4)
    val view = l.view(2, 5)
    println(view.mkString(","))
  }

}
