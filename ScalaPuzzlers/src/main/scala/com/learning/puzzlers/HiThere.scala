package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/3/22.
  */
object HiThere {

  def process() = {
    val res = List(1, 2).map{x => println("Hi"); x + 2}
    println(res)
  }

  def main(argsgi: Array[String]): Unit = {
    process()
  }

}
