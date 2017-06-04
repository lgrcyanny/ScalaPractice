package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/5/30.
  */
object IfAtFirstYouDontSucceed {

  def process() = {
    var x = 0
    lazy val y = 1 / x
    try {
      println(y)
    } catch {
      case _: Exception =>
        x = 1
        println(y)
    }
  }

  def main(args: Array[String]): Unit = {
    process()
  }
}
