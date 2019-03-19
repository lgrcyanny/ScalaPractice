package com.cyanny.learning.scala.concurrent

import java.util.concurrent.{CountDownLatch, Executors}

import scala.concurrent.ExecutionContext

object CountDownLatchDemo {

  val executors = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(10))

  class Worker(startSignal: CountDownLatch, doneSignal: CountDownLatch) extends Runnable {
    override def run(): Unit = {
      println(s"Worker ${Thread.currentThread().getId} is ready")
      startSignal.await()
      println("Worker running...")
      Thread.sleep(1000)
      println("Worker done...")
      doneSignal.countDown()
    }
  }

  class Driver(n: Int) {
    val startSignal = new CountDownLatch(1)
    val doneSignal = new CountDownLatch(n)

    def run(): Unit = {
      for (i <- 1 to n) {
        val t = new Worker(startSignal, doneSignal)
        executors.submit(t)
      }
      println("Driver is doing something...")
      startSignal.countDown()
      doneSignal.await()
      println("Driver is done")
    }
  }

  def main(args: Array[String]): Unit = {
    val d = new Driver(5)
    d.run()
  }

}
