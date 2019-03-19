package com.cyanny.learning.scala.akka

import java.util.concurrent.Executors

import scala.concurrent.{ExecutionContext, Future, Promise}

object PromiseDemo {
  implicit val futureContext = ExecutionContext.fromExecutor(Executors.newCachedThreadPool())

  def main(args: Array[String]): Unit = {
    val promise = Promise[Int]()
    val f = promise.future
    val producer = Future {
      println(s"Starting producer: ${Thread.currentThread().getName}")
      Thread.sleep(5000)
      promise.success(10)
      println("producer continue doing..")
    }
    val consumer = Future {
      println(s"consumer started: ${Thread.currentThread().getName}")
      f.onSuccess {
        case value =>
          println(s"Got result: ${value}")
      }
      println("consumer continue doing..")
    }
  }
}
