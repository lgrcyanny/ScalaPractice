package com.chapter12

import com.chapter12.StackableTraits.{Incrementing, BasicIntQueue}

import scala.collection.mutable.ArrayBuffer

/**
 * Created by lgrcyanny on 16/3/15.
 */
object StackableTraits {
  abstract class IntQueue {
    def get(): Int
    def put(x: Int)
  }

  class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]()
    def get(): Int = buf.remove(0)
    def put(x: Int) = buf += x
    override def toString = buf.toString()
  }

  trait Doubling extends IntQueue {
    abstract override def put(x: Int) {
      println("Doubling")
      super.put(2 * x)
    }
  }

  trait Incrementing extends IntQueue {
    abstract override def put(x: Int): Unit = {
      println("Incrementing")
      super.put(x + 1)
    }
  }

  def main(args: Array[String]) {
    val queue = new BasicIntQueue with Incrementing with Doubling
    queue.put(1)
    queue.put(2)
    println(queue.toString)
  }
}

