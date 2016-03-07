package com.chapter6

/**
 * Created by lgrcyanny on 16/2/15.
 */
// n is numerator, d is denominator
class Rational(n: Int, d: Int) {
  require(d != 0)
  val g = gcd(n, d)
  val numerator = n / g
  val denominator = d / g

  def this(n: Int) = this(n, 1)

  override def toString = s"$numerator/$denominator"

  def +(that: Rational) =
    new Rational(numerator * that.denominator + that.numerator * denominator, denominator * that.denominator)

  def +(that: Integer): Rational = this.+(new Rational(that))

  def *(that: Rational) = new Rational(numerator * that.numerator, denominator * that.denominator)

  def lessThan(that: Rational): Boolean = numerator * that.denominator < that.numerator * denominator

  def max(that: Rational): Rational = if (lessThan(that)) that else this

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}

object Rational {
  implicit def intToRational(x: Int) = new Rational(x)
  def main(args: Array[String]) {
    val r1 = new Rational(1, 2)
    val r2 = new Rational(6, 3)
    println(3 + r1)
  }
}
