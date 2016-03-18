package com.chapter12

/**
 * Created by lgrcyanny on 16/3/15.
 */
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)
  val g = gcd(n, d)
  val numerator = n / g
  val denominator = d / g

  def this(n: Int) = this(n, 1)

  override def toString = s"$numerator/$denominator"
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  override def compare(that: Rational): Int =
    (this.numerator * that.denominator) - (that.numerator * this.denominator)
}

object Rational {
  def main(args: Array[String]) {
    val r1 = new Rational(3, 4)
    val r2 = new Rational(1, 2)
    println(r1 > r2)
  }
}
