package com.cyanny.learning.scala.concurrent

import java.util.concurrent.{ArrayBlockingQueue, ConcurrentLinkedDeque, LinkedBlockingDeque}

object ArrayBlockingQueueDemo {

  // if exceed capcity, queue will be blocked
  def testCapacity() = {
    val queue = new ArrayBlockingQueue[Int](10)
    for (i <- 1 to 100) {
      queue.put(i)
    }
    println(queue.size())
  }

  def testLinkedQueue() = {
    val queue = new LinkedBlockingDeque[Int]()
    for (i <- 1 to 100) {
      queue.put(i)
    }
    println(queue.size())
  }

  def main(args: Array[String]): Unit = {
//    testCapacity()
    testLinkedQueue()
  }

}
