package com.cyanny.learning.scala.concurrent

object ParallelCollectionDemo {

  def process() = {
    val pv = Vector(1, 2, 3, 4).par
    val sum1 = pv.reduce(_ + _)
    val sum2 = pv.reduce(_ + _)
    println(s"sum1: $sum1, sum2: $sum2")
  }

  def sideEffects() = {
    var sum = 0
    val list = (1 to 10000).toList.par
    list.foreach(sum += _)
    println("side effects sum1:" + sum)
    sum = 0
    list.foreach(sum += _)
    println("side effects sum2:" + sum)
  }

  def nonAssociativeOperations() = {
    val list = (1 to 1000).toList.par
    val res1 = list.reduce(_ - _)
    val res2 = list.reduce(_ - _)
    println(s"res1: $res1, res2: $res2")
  }

  def main(args: Array[String]): Unit = {
    process()
    sideEffects()
    nonAssociativeOperations()
  }

}
