package com.chapter19

/**
  * Created by lgrcyanny on 16/6/4.
  */
class Cell[T](init: T) {
  private var x = init
  def set(y: T) = {
    x = y
  }
  def get = x
}

object TestArray {
  def main(args: Array[String]) {
    val a1 = Array[String]("a", "b")
    var b1: Array[Object] = a1.asInstanceOf[Array[Object]]
    println(b1)
  }
}
