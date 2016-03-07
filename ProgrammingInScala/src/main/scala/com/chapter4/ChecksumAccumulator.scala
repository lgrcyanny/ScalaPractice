package com.chapter4

import scala.collection.mutable

/**
 * Created by lgrcyanny on 16/1/27.
 */
object ChecksumAccumulator {
  private val cache = mutable.Map[String, Long]()

  def calculate(s: String): Long = {
    if (cache.contains(s)) {
      cache(s)
    } else {
      val acc = new ChecksumAccumulator
      for (c ← s) {
        acc.add(c.toByte)
      }
      val cs = acc.checksum()
      cache += s -> cs
      cs
    }
  }

  def main(args: Array[String]) {
    val checkSum = ChecksumAccumulator.calculate("hello")
    println(checkSum)
  }
}
class ChecksumAccumulator {
  private var sum = 0

  def add(b: Byte) {sum += b}

  def checksum(): Long = ~(sum & 0xFF) + 1

}

