package com.chapter29

/**
  * Created by lgrcyanny on 17/2/6.
  */
class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer = (if (d < 0) -n else n) / g
  val denom = d.abs / g

  private def gcd(n: Int, d: Int): Int = if (d == 0) n else gcd(d, n % d)

  override def equals(other : scala.Any): Boolean = {
    other match {
      case that: Rational =>
        (that canEqual this) &&
        numer == that.numer &&
        denom == that.denom
      case _ => false
    }
  }

  def canEqual(other: Any): Boolean =
    other.isInstanceOf[Rational]
  override def hashCode: Int =
    41 * (41 + numer) + denom

  override def toString =
    if (denom == 1) numer.toString else numer +"/"+ denom
}

object Rational {
  def main(args: Array[String]): Unit = {
    val a = new Rational(10, 20)
    val b = new Rational(1, 2)
    println(a)
    println(b)
    println(a == b)
  }
}
