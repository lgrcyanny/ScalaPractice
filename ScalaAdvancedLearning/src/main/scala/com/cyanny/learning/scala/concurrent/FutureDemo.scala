package com.cyanny.learning.scala.concurrent


import java.util.concurrent.TimeUnit

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
object FutureDemo {
  import scala.concurrent.ExecutionContext.Implicits.global
  def process() = {
    val f1 = Future {
      5
    }
    val f2 = Future {
      6
    }
    val results = for {
      i <- f1
      j <- f2
    } yield i + j
    val tuple = Await.result(results, Duration(1000, TimeUnit.MILLISECONDS))
    println(tuple)
  }

  def main(args: Array[String]): Unit = {
    process()
  }

}
