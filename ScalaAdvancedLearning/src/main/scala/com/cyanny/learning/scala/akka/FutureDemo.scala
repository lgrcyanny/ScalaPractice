package com.cyanny.learning.scala.akka

import java.util.concurrent.Executors

import scala.concurrent.{ExecutionContext, Future}

object FutureDemo {
  implicit val executors = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(10))

  def process() = {
    val futures = for (i <- 1 to 100) yield Future(i * 2)
    val futureSum = Future.fold(futures)(0)(_ + _)
    futureSum.foreach(println)
  }

  def main(args: Array[String]): Unit = {
    process()
  }

}
