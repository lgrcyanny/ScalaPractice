package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/10/23.
  */
object AcceptsAnyArgs {

  def prependIfLong(candidate: Any, elements: Any*) = {
    if (candidate.toString.length > 1) {
      candidate +: elements
    } else {
      elements
    }
  }

  def prependIfLongRefac(candidate: Any)(elements: Any*): Seq[Any] = {
    if (candidate.toString.length > 1) {
      candidate +: elements
    } else {
      elements
    }
  }

  def main(args: Array[String]): Unit = {
    println(prependIfLong("I", "love", "scala")(0))
    println(prependIfLongRefac("I", "love", "scala")(0))
  }

}
