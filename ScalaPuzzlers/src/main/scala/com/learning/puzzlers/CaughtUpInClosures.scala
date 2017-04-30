package com.learning.puzzlers

import scala.collection.mutable.ArrayBuffer
/**
  * Created by lgrcyanny on 17/4/30.
  */
object CaughtUpInClosures {

  def process() = {
    val data = Seq(100, 110, 120)
    val accessors1 = new ArrayBuffer[() => Int]()
    val accessors2 = new ArrayBuffer[() => Int]()
    var j = 0
    for (i <- 0 until data.length) {
      accessors1 += (() => data(i))
      accessors2 += (() => data(j))
      j += 1
    }
    accessors1.foreach(a => println(a()))
    accessors2.foreach(a => println(a()))
  }

  def main(args: Array[String]): Unit = {
    process()
  }
}
