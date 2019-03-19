package com.cyanny.learning.scala.concurrent

import java.util.concurrent.{ConcurrentLinkedDeque, ConcurrentLinkedQueue, CyclicBarrier, Executors}

import scala.concurrent.ExecutionContext
import scala.collection.JavaConverters._

object CyclicBarrierDemo {

  val executors = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(10))

  class Worker(barrier: CyclicBarrier,
               bord: ConcurrentLinkedQueue[Int]) extends Runnable {
    override def run(): Unit = {
      (1 to 10).foreach(bord.add(_))
      barrier.await()
    }
  }

  class Driver {
    val mainBord = new ConcurrentLinkedQueue[Int]()

    def run(): Unit = {
      val workers = 8
      val barrier = new CyclicBarrier(8, new Runnable {
        override def run(): Unit = {
          println(s"all elements: ${mainBord.size()}, all sum: ${mainBord.asScala.sum}")
        }
      })
      for (i <- 1 to workers) {
        executors.submit(new Worker(barrier, mainBord))
      }
    }

  }

  def main(args: Array[String]): Unit = {
    val d = new Driver
    d.run()
  }


}
