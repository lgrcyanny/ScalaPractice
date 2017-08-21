package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/8/1.
  */
object ICanHasPadding {

  // bad implementation
//  implicit class Padder(val sb: StringBuilder) extends AnyVal {
//    def pad2(width: Int) = {
// // it will throw   java.lang.StringIndexOutOfBoundsException
//      (1 to (width - sb.length)) foreach {sb.append('*')}
//      sb
//    }
//  }

  // good implementation
  implicit class Padder(val sb: StringBuilder) extends AnyVal {
    def pad2(width: Int) = {
      (1 to (width - sb.length)) foreach {
       _ => sb.append('*')
      }
      sb
    }
  }

  def main(args: Array[String]): Unit = {
    // length == 14
    val greeting = new StringBuilder("Hello, kitteh!")
    println(greeting pad2 20)
    // length == 9
    val farewell = new StringBuilder("U go now.")
    println(farewell pad2 20)
  }

}
