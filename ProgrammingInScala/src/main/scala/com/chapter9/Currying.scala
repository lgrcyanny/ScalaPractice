package com.chapter9

/**
 * Created by lgrcyanny on 16/3/3.
 */
object Currying {
  def sum(x: Int)(y: Int) = x + y

  def first(x: Int) = sum(x)_

  def main(args: Array[String]) {

  }

}
