package com.chapter16

/**
  * Created by lgrcyanny on 16/4/24.
  */
object MergeSort {

  def mergeSort[T](list: List[T])(implicit ord: Ordering[T]): List[T]= {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x1 :: xs1, y1 :: ys1) =>
        if (ord.lt(x1, y1)) x1 :: merge(xs1, ys) else y1 :: merge(xs, ys1)
    }
    val n = list.length / 2
    if (n == 0) {
      list
    } else {
      val (xs, ys) = list.splitAt(n)
      val left = mergeSort(xs)
      val right = mergeSort(ys)
      merge(left, right)
    }
  }

  def main(args: Array[String]) {
    val list = List(6, 71, 8, 11, 3, 4, 62, 7, 1, 0)
    val sorted = mergeSort(list)
    println(sorted)
  }
}
