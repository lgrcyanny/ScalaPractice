package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/11/16.
  */
object QuiteOutspokenType {
  class QuiteType {
    implicit val stringToInt = (_: String).toInt
    println("4" - 2)
  }

  class OutspokenType {
    // StackOverflow error
    implicit val stringToInt: String => Int = _.toInt
//    implicit def stringToInt: String => Int = _.toInt
    println("4" - 2)
  }

  def main(args: Array[String]): Unit = {
    new QuiteType()
    new OutspokenType()
  }

}
