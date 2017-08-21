package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/6/23.
  */
object ReturnToMe {

  def sumUp() = {
    def one(x: Int): Int = {
      return x;
      1
    }
    val two = (x: Int) => {
      2
    }
    1 + one(1) + two(2)
  }

  def main(args: Array[String]): Unit = {
    sumUp()
  }

}
