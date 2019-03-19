package com.cyanny.learning.scala.concurrent

import java.util.concurrent.{Callable, ConcurrentHashMap, Executors, FutureTask}

import scala.concurrent.{CancellationException, ExecutionContext, Future}

object MemorizerCacheDemo {

  implicit val executors = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(10))

  class Memorizer(functor: String => Int) {
    private val cache = new ConcurrentHashMap[String, FutureTask[Int]]()

    def get(key: String): Int = {
      var isBreak = false
      var value: Int = -1
      while (!isBreak) {
        var ft = cache.get(key)
        if (ft == null) {
          val callable = new Callable[Int] {
            override def call(): Int = functor(key)
          }
          ft = new FutureTask[Int](callable)
          cache.putIfAbsent(key, ft)
          ft.run()
        }
        try {
          value = ft.get()
          isBreak = true
        } catch {
          case e: CancellationException =>
            cache.remove(key)
          case e: Exception => throw e
        }
      }
      value
    }
  }

  def compute(n: String): Int = {
    println(s"computing for:$n")
    n.toInt * 2
  }

  def main(args: Array[String]): Unit = {
    val memo = new Memorizer(compute _)
    println(memo.get("1"))
    println(memo.get("2"))
    println(memo.get("1"))
    println(memo.get("1"))
  }

}
