package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/10/12.
  */
object TypeExtortion {


  def process() = {
    val zippedList = (List(1, 3, 5), List(2, 4, 6)).zipped
    val (x, y) = zippedList.find(_._1 > 10).getOrElse(10)
    println(s"Found $x, $y")
  }

  def main(args: Array[String]): Unit = {
    // Exception in thread "main" scala.MatchError: 10 (of class java.lang.Integer)
    process()
  }

}
