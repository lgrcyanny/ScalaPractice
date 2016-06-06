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
      case head :: xs1 => if (ord.lt(x, head)) x :: xs else head :: insert(x, xs1)
    }
    xs match {
      case Nil => Nil
      case x :: xs1 => insert(x, isort(xs1))
    }
  }

  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil => ys
    case k :: ks => k :: concat(ks, ys)
  }

  def length[T](xs: List[T]): Int = {
    def iter[T](xs: List[T], length: Int): Int = xs match {
      case Nil => length
      case x :: xs1 => iter(xs1, length + 1)
    }
    iter(xs, 0)
  }

  def reverse[T](xs: List[T]): List[T] = xs match {
    case Nil => Nil
    case x :: xs1 => reverse(xs1) ::: List(x)
  }

  def reverse2[T](xs: List[T]): List[T] = {
    xs.foldLeft(List[T]())((xs: List[T], x: T) => x :: xs)
  }

  def listPattern() = {
    val a :: b :: rest = List(1, 2)
  }

  def zipTest() = {
    val list = "abcdef".toList
    list.indices zip list
  }

  def addStringTest() = {
    val list = List("a", "b", "c", "d")
    val buf = new StringBuilder
    list.addString(buf, "[", ";", "]")
    println(buf.toString())
  }

  def main(args: Array[String]) {
    val list1 = List(1, 2, 3)
    val list2 = List(4, 5, 6)
    val list3 = concat(list1, list2)
    println(list3)
    println(length(list1))
    println(zipTest())
    addStringTest()
  }
}
