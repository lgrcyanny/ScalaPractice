package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/6/26.
  */
object CountMeNow {
  var x = 0
  def counter() = {x += 1; x}
  def add(a: Int)(b: Int) =  a + b
  val adder1 = add(counter)(_)
  val adder2 = add(counter) _

  def main(args: Array[String]): Unit = {
    println("x = " + x)
    println(adder1(10))
    println("x = " + x)
    println(adder2(10))
    println("x = " + x)
    // output is:
//    x = 1
//    12
//    x = 2
//    11
//    x = 2
  }

}
