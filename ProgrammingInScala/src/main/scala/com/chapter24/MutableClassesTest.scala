package com.chapter24

import scala.collection.mutable.ListBuffer

/**
  * Created by lgrcyanny on 16/10/28.
  */
object MutableClassesTest {
  def testListBuffer() = {
    val buffer = new ListBuffer[Int]
    buffer += 1
    buffer += 2
    println(buffer.toList)
  }

  def main(args: Array[String]): Unit = {
    testListBuffer()
    println(args.toList)
  }

}
