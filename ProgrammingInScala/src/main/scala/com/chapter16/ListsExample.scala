/**
  * Created by lgrcyanny on 16/4/19.
  */
package com.chapter16

object ListsExample {
  val list = List(1, 3, 4)
  val list2: List[Nothing] = List()

  // insertion sort
  def isort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    // insert x into sorted xs
    def insert(x: T, xs: List[T]): List[T] = xs match {
      case Nil => x :: Nil
      case head :: xs1 => if (ord.lt(x, head)) x :: head :: xs1 else head :: insert(x, xs1)
    }
    xs match {
      case Nil => Nil
      case x :: xs1 => insert(x, isort(xs1))
    }
  }

  def main(args: Array[String]) {
    val list = List(5, 1, 6, 7)
    val sorted = isort(list)
    println(sorted)
  }
}
