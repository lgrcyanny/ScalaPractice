package com.chapter25

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Created by lgrcyanny on 16/11/22.
  */
object Builders {
  val buf = new ArrayBuffer[Int]()
  val bldr: mutable.Builder[Int, Array[Int]] = buf mapResult(_.toArray)

  def main(args: Array[String]): Unit = {
    buf += 1
    buf += 2
    val result = bldr.result()
    for (x <- result) {
      println(x)
    }
  }

}
