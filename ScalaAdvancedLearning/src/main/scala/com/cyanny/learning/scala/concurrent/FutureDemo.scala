package com.cyanny.learning.scala.concurrent

import scala.concurrent.Future
object FutureDemo {
  import scala.concurrent.ExecutionContext.Implicits.global
  def process() = {
    val fut = Future {
      Thread.sleep(1000)
      21 + 21
    }
    println(fut.isCompleted)
    println(fut.value)
    Thread.sleep(1000)
    println(fut.isCompleted)
    println(fut.value)
  }

  def main(args: Array[String]): Unit = {
    process()
  }

}
