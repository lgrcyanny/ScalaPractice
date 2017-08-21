package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/7/14.
  */
object OverloadedInformation {

  def overloadedA(u: Unit) = "I accetp unit"
  def overloadedA(u: Unit, v: Nothing) = "I accept unit and nothing"

  def overloadedB(n: Unit) = "I accept a Unit"
  def overloadedB(n: Nothing) = "I accept Nothing"

  def main(args: Array[String]): Unit = {
    println(overloadedA(99))
//    println(overloadedB(99)) // compile error
  }

}
