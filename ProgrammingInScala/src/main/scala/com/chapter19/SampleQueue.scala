package com.chapter19

/**
  * Created by lgrcyanny on 16/5/30.
  */
class SampleQueue[T](val leading: List[T], val trailing: List[T]) {

  private def mirror = {
    if (leading.isEmpty) {
      new SampleQueue(trailing.reverse, Nil)
    } else {
      this
    }
  }

  def head = mirror.leading.head

  override def toString = leading.toString + trailing.reverse

  def tail = {
    val q = mirror
    new SampleQueue(q.leading.tail, q.trailing)
  }
}

object SampleQueue {
  def apply[T](xs: T*) = new SampleQueue(xs.toList, Nil)

  def main(args: Array[String]) {
    val q = SampleQueue(1 ,2 , 3)
    println(q)
  }
}

