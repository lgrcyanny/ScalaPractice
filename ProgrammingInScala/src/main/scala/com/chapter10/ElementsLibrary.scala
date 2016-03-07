package com.chapter10

/**
 * Created by lgrcyanny on 16/3/4.
 */
class ElementsLibrary {
  abstract class Element {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length
    final def print(): Unit = {
      println(contents)
    }
  }

  class ArrayElement(val contents: Array[String]) extends Element {

  }

  class LineElement(s: String) extends ArrayElement(Array(s)) {
    override def width: Int = s.length
    override def height: Int = 1
  }

  class UniformElement(ch: Char, override val height: Int, override val width) extends Element {
    private val line = ch.toString * width
    override val contents = Array.fill(height)(line)
  }

  def main(args: Array[String]) {
    val ae = new ArrayElement(Array("Hello", "World"))
  }
}
