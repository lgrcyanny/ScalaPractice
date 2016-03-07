package com.chapter9

/**
 * Created by lgrcyanny on 16/3/3.
 */
object ByNameParamerter {
  def byNameAssert(enable: Boolean)(predicate: => Boolean) = {
    if (enable && !predicate) throw new AssertionError()
  }

  def main(args: Array[String]) {
    byNameAssert(true)(5 > 3)
  }
}
