package com.cyanny.learning.scala.functional.higher

object Fibonacci {

  def fib(n: Int): Int = {
    def iter(index: Int, p: Int, q: Int): Int = {
      if (index == n - 1) {
        p + q
      } else if (index == 0 || index == 1) {
        iter(index + 1, 0, 1)
      } else {
        iter(index + 1, q, p + q)
      }
    }
    iter(0, 0, 0)
  }

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 11) {
      println(fib(i))
    }
  }

}
