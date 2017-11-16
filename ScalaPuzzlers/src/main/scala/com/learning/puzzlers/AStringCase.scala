package com.learning.puzzlers


/**
  * Created by lgrcyanny on 17/10/24.
  */
object AStringCase {
  def objFromJava: Object = "string"
  def stringFromJava: String = null

  def printLengthIfString(str: AnyRef) = str match {
    case null => println("got null")
    case astr: String => println(s"str $astr, length: ${astr.length}")
    case _ => println("nothing")
  }

  def main(args: Array[String]): Unit = {
    printLengthIfString(objFromJava)
    printLengthIfString(stringFromJava)
    println(null.isInstanceOf[String] )
  }

}
