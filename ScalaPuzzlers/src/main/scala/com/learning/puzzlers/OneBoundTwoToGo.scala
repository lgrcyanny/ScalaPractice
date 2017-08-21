package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/7/3.
  */
object OneBoundTwoToGo {
  def invert(v3: Int)(v2: Int = 2, v1: Int = 1) = {
    println(s"$v1, $v2, $v3")
  }

  def invert2(v3: Int)(v2: Int)(v1: Int) = {
    println(s"$v1, $v2, $v3")
  }

  def main(args: Array[String]): Unit = {
    val invert3: (Int, Int) => Unit = invert(3) _
//    invert3(v1 = 2) // compile error
    invert3(v1 = 2, v2 = 1)

    val invert3_2: (Int) => (Int) => Unit = invert2(3) _
    invert3_2(2)(1)
  }

}
