package com.chapter21

/**
  * Created by lgrcyanny on 16/7/15.
  */
object ConvertingReceivers {
  case class Rational(num: Int, deno: Int) {
    def + (that: Rational) = Rational(this.num * that.deno + that.num * this.deno, this.deno * that.deno)
    def + (that: Int) = Rational(this.num *  + that * this.num, this.deno)
    override def toString = s"$num / $deno"
  }

  implicit def intToRational(x: Int) = new Rational(x, 1)

  def main(args: Array[String]) {
    val r = Rational(3, 5)
    println(1 + r)
  }
}
