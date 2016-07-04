package com.chapter19

/**
  * Created by lgrcyanny on 16/5/30.
  */
class SampleQueue[+T](private[this] var leading: List[T], private[this] var trailing: List[T]) {

  private def mirror() = {
    if (leading.isEmpty) {
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    } else {
      this
    }
  }

  def head = {
    mirror()
    leading.head
  }

  override def toString = leading.toString + trailing.reverse

  def tail: SampleQueue[T] = {
    mirror()
    new SampleQueue(leading.tail, trailing)
  }
}

object SampleQueue {
  def apply[T](xs: T*) = new SampleQueue(xs.toList, Nil)

  def main(args: Array[String]) {
    val q = SampleQueue(1 ,2 , 3)
    println(q)
  }
}

