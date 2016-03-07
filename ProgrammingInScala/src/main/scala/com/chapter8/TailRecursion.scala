package com.chapter8

/**
 * Created by lgrcyanny on 16/3/1.
 */
object TailRecursion {
  // so far not right
  def approximate(guess: Double, n: Double): Double = if (isGoodEnough(guess, n)) guess else approximate(improve(guess, n), n)

  def isGoodEnough(guess: Double, n: Double) = Math.abs(guess * guess  - n)  < 1e-9

  def improve(guess: Double, n: Double): Double = (guess + n / guess) / 2

  def main(args: Array[String]) {
    println(approximate(1.0, 3))
  }
}
