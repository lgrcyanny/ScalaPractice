package com.cyanny.learning.scala.concurrent

import java.util.concurrent.{Executors, TimeUnit}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

object ParallelCollection {

  implicit val executors = ExecutionContext.fromExecutorService(Executors.newCachedThreadPool())

  def withTime[T](msg: String)(body: => T): T = {
    val startTime = System.currentTimeMillis()
    val res = body
    val endTime = System.currentTimeMillis()
    println(s"action $msg: ${endTime - startTime}ms")
    res
  }

  def process(seq: Seq[Int]) = {
    withTime("single thread") {
      seq.map(x => x * 2)
    }
    val parSeq = seq.par
    withTime("par collection") {
      parSeq.map(x => x * 2)
    }
    withTime("future tests") {
      val tasks = seq.map { x =>
        Future {
          x * 2
        }
      }
      tasks.foreach(t => Await.ready(t, Duration(6000, TimeUnit.MILLISECONDS)))
    }

  }

  def main(args: Array[String]): Unit = {
    val steps= 100
    val seq = 1 to 10000000
    for (i <- 0 until steps) {
      process(seq)
    }
  }

}
