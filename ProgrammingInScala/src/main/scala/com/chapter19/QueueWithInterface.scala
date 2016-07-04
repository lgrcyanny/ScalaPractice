package com.chapter19

/**
  * Created by lgrcyanny on 16/6/4.
  */
trait Queue[+T] {
  def head: T
  def tail: Queue[T]
  def enqueue[U >: T](x: U): Queue[U]
}

object Queue {
  def apply[T](xs: T*): Queue[T] = new QueueImpl(xs.toList, Nil)

  private class QueueImpl[T](private val leading: List[T],
                             private val trailing: List[T]) extends Queue[T] {
    private def mirror = {
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this
    }

    override def head: T = mirror.leading.head
    override def tail: Queue[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue[U >: T](x: U): Queue[T] = new QueueImpl(leading, x :: trailing).asInstanceOf[Queue[T]]

    override def toString = mirror.leading.mkString(",") + "," + mirror.trailing.reverse.mkString(",")
  }
}

object Test {
  def main(args: Array[String]) {
    val q = Queue[Int]((1 to 10):_*)
    val b: Queue[Any] = q.enqueue("Str")
    println(b.tail)
  }
}
