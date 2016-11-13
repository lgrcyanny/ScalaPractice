package com.chapter20

/**
  * Created by lgrcyanny on 16/7/8.
  */
object EnumerationsTest {
  object Color extends Enumeration {
    val Red, Green, Blue = Value
  }

  def main(args: Array[String]) {
    println(Color(1).toString)
  }
}
