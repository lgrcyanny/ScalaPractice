package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/7/17.
  */
object WhatsInAName {
  class SimpleAdder {
    def add(x: Int = 1, y: Int = 2) = x + y
  }

  class AdderWithBonus extends SimpleAdder {
    override def add(y: Int = 3, x: Int = 4): Int =
      super.add(x, y) + 10
  }

  def main(args: Array[String]): Unit = {
    val adder = new AdderWithBonus
    println(adder.add(y = 0))
    println(adder add 0)
  }
}
