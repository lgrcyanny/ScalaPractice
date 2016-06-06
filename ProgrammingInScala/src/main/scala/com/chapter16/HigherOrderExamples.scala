package com.chapter16

/**
  * Created by lgrcyanny on 16/4/27.
  */
object HigherOrderExamples {
  def reverseList[T](xs: List[T]) = xs.foldLeft(List[T]()){(ys, y) => y :: ys}


  def main(args: Array[String]) {
    val list = (1 to 10).toList
    val res = reverseList(list)
    println(res)
  }
}
