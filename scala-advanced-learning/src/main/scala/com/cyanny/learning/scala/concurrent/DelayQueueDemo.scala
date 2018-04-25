package com.cyanny.learning.scala.concurrent

import java.util.UUID
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.{BlockingQueue, DelayQueue, Delayed, Executors, TimeUnit}

import com.google.common.primitives.Ints

import scala.concurrent.ExecutionContext

/**
  * http://www.baeldung.com/java-delay-queue
  */
object DelayQueueDemo {

  val executors = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(100))

  case class DelayMessage(data: String, startTime: Long, interval: Long) extends Delayed {
    override def getDelay(unit: TimeUnit): Long = {
      val delay = interval - (System.currentTimeMillis() - startTime)
      unit.convert(delay, TimeUnit.MILLISECONDS)
    }

    override def compareTo(o: Delayed): Int = {
      Ints.saturatedCast(this.startTime - o.asInstanceOf[DelayMessage].startTime)
    }

    override def toString: String = {
      val current = System.currentTimeMillis()
      s"""data: $data, startTime: $startTime, currentTime: ${current}, delayed: ${current - startTime}ms"""
    }
  }

  class Producer(queue: BlockingQueue[DelayMessage], elementsDelay: Long = 5000) extends Runnable {
    override def run(): Unit = {
      while(true) {
        val message =
          DelayMessage(UUID.randomUUID().toString, System.currentTimeMillis(), elementsDelay)
        queue.put(message)
        Thread.sleep(200)
      }
    }
  }

  class Consumer(queue: BlockingQueue[DelayMessage]) extends Runnable {
    val numberElementsConsumed = new AtomicInteger(0)
    override def run(): Unit = {
      while (true) {
        val message = queue.take()
        println(message)
        Thread.sleep(200)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val queue = new DelayQueue[DelayMessage]()
    val producer = new Producer(queue)
    val consumer = new Consumer(queue)
    executors.submit(producer)
    executors.submit(consumer)
  }

}
