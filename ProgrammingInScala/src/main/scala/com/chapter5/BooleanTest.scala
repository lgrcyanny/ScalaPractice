package com.chapter5

/**
 * Created by lgrcyanny on 16/2/3.
 */

abstract class Boolean {
  def ifThenElse[T](x: => T, y: => T): T

  def &&(x: => Boolean) = ifThenElse(x, _false)
  def ||(x: => Boolean) = ifThenElse(_true, x)
}

object _true extends Boolean {
  def ifThenElse[T](x: => T, y: => T): T = x
  override def toString = "true"
}

object _false extends Boolean {
  def ifThenElse[T](x: => T, y: => T): T = y
  override def toString = "false"
}


object BooleanTest {
  def main(args: Array[String]) {
    println(_true && _false)
  }
}
