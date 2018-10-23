package com.cyanny.learning.scala.performance

import java.util.concurrent.ConcurrentHashMap

object CpuUsageDemo {

  def tictoc[T](f: => T): T = {
    val tic = System.currentTimeMillis()
    val res = f
    val toc = System.currentTimeMillis()
    println(s"time taken: ${toc - tic}ms")
    res
  }

  def generateIdentity(firstId: Int, secondId: Int) = s"$firstId,$secondId"

  def process(n: Int): Unit = {
    val data = (1 to n).map { x =>
      val id = (Math.random() * 100 + 1).toInt
      generateIdentity(id, id)
    }
    tictoc {
      data.map { i =>
        i.split(",")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    process(100)
    process(1000)
    process(10000)
    process(100000)
    process(1000000)
    process(10000000)
//    process(1000000000)
  }

}
