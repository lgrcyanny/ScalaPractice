package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/4/13.
  */
object NowYouSeeMe {
  trait A {
    val foo: Int
    val bar = 10
    println(s"A foo=$foo, bar=$bar")
  }

  class B extends A {
    val foo: Int = 25
    println("In B: foo: " + foo + ", bar: " + bar)
  }

  class C extends B {
    override val bar = 99
    println("In C: foo: " + foo + ", bar: " + bar)
  }

  def main(args: Array[String]): Unit = {
    new C()
  }

}
