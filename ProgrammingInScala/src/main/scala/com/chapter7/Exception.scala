package com.chapter7

/**
 * Created by lgrcyanny on 16/2/23.
 */
object Exception {
  def main(args: Array[String]) {
    val n = 2
    val half: Int = if (n % 2 == 0) n / 2 else throw new IllegalArgumentException("not event")
  }
}
