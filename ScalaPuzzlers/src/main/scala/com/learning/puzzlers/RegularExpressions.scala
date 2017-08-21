package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/7/27.
  */
object RegularExpressions {
  def traceIt[T <: Iterator[_]](it: T) = {
    println(s"TRACE: using iterator '${it}'")
    it
  }

  def puzzleTest() = {
    val msg = "I love Scala"
    println("First match index: " +
      traceIt("a".r.findAllIn(msg)).start)
    // compile error, No match available
//    println("First match index: " +
//      "a".r.findAllIn(msg).start)
    val iter = "a".r.findAllIn(msg)
    iter.hasNext
    println(iter)
  }

  def main(args: Array[String]): Unit = {
    puzzleTest()
  }
}
