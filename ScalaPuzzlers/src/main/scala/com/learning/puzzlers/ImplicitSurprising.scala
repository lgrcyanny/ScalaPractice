package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/7/7.
  */
object ImplicitSurprising {

  implicit val z1 = 2
  def add(x: Int)(y: Int)(implicit z: Int) = x + y + z
  def addTo(n: Int) = add(n) _

  def main(args: Array[String]): Unit = {
    implicit val z2 = 3
    val addTo1 = addTo(1)
    val res = addTo1(2)
//    addTo1(2)(3) compile error
    println(res)

    val anonFunWithImplicit = {
      x: Int => implicit y: Int => z: Int => x + y + z
    }
  }

}
