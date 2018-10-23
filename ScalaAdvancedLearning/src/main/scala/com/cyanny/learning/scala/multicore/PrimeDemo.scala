package com.cyanny.learning.scala.multicore

object PrimeDemo {

  def isPrime(n: Long): Boolean = {
    var i = 2
    var isPrime = true
    var break = false
    while (i * i < n && !break) {
      if (n % i == 0) {
        isPrime = false
        break = true
      }
      i = i + 1
    }
    isPrime
  }

  def main(args: Array[String]): Unit = {
    println(isPrime(10000000000L))
  }

}
