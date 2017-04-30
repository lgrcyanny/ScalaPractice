package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/4/28.
  */
object ArgArrgh {
  def applyNMulti[T](n: Int)(arg: T, f: T => T) = (1 to n).foldLeft(arg){(acc, _) => f(acc)}
  def applyNCurried[T](n: Int)(arg: T)(f: T => T) = (1 to n).foldLeft(arg) { (acc, _) => f(acc)}
  def nextInt(n: Int) = n * n + 1
  def nextNumber[N](n: N)(implicit numericOps: Numeric[N]) = numericOps.plus(numericOps.times(n, n), numericOps.one)

  def main(args: Array[String]): Unit = {
    println(applyNMulti(3)(2, nextInt))
    println(applyNCurried(3)(2)(nextInt))
//    println(applyNMulti(3)(2.0, nextNumber))
//    println(applyNCurried(3)(2.0)(nextNumber))
  }

}
