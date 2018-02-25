package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/12/4.
  */
object SetTheRecordStraight {

  def process() = {
    val numbers = List("1", "2").toSet.apply() + "3"
    println(numbers)

    val numbers2 = List("1", "2").toSet + "3"
    println(numbers2)
  }

  def main(args: Array[String]): Unit = {
    process()
  }

}
