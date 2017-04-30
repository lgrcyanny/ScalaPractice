package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/4/3.
  */
object CaseClassLocations {
  trait A {
    val audience: String
    println(s"Hello $audience")
  }

  class BMember(a: String = "world") extends A {
    val audience: String = a
    println(s"BMember repeat: Hello $audience")
  }

  class BConstructor(val audience: String = "world") extends A {
    println(s"BConstructor repeat: Hello $audience")
  }

  def main(args: Array[String]): Unit = {
    val b1 = new BMember("Readers")
    val b2 = new BConstructor("Readers")
  }
}
