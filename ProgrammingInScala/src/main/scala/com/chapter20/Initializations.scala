package com.chapter20


/**
  * Created by lgrcyanny on 16/6/30.
  */
object Initializations {

  trait RationalTrait {
    val numerArg: Int
    val donomArg: Int
  }

  trait LazyRationalTrait extends RationalTrait {
    lazy val numer = numerArg / g
    lazy val donom = donomArg / g
    lazy val g = gcd(numerArg, donomArg)
    def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }

  def main(args: Array[String]) {
    new {
      val numerArg = 1
      val donomArg = 1
    } with RationalTrait
  }
}
