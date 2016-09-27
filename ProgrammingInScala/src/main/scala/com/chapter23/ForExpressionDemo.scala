package com.chapter23

/**
  * Created by lgrcyanny on 16/8/30.
  */
object Demo {
  def map[A, B](xs: List[A], f: A => B): List[B] = {
    for (x <- xs) yield f(x)
  }

  def flatMap[A, B](xs: List[A], f: A => List[B]) = {
    for (x <- xs; y <- f(x)) yield y
  }

  def filter[A](xs: List[A], f: A => Boolean) = {
    for (x <- xs if f(x)) yield x
  }
}

object Test {
  def main(args: Array[String]) {
//    for (y <- Demo) yield y
  }
}
