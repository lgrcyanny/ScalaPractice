package com.chapter10

/**
 * Created by lgrcyanny on 16/3/4.
 */
object ElementsLibrary {
  abstract class Element {
    import Element._
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length

    def above(that: Element): Element = {
      val this1 = this.widen(that.width)
      val that1 = that.widen(this.width)
      elem(this1.contents ++ that1.contents)
    }

    def beside(that: Element): Element = {
      val this1 = this heighten that.height
      val that1 = that heighten this.height
      elem(
        for ((line1, line2) <- this1.contents zip that1.contents)
          yield line1 + line2)
    }

    def widen(w: Int): Element = {
      if (w < width) this
      else {
        val left = elem(' ', (w - width) / 2, height)
        val right = elem(' ', w - width - left.width, height)
        left beside this beside right
      }
    }

    def heighten(h: Int): Element = {
      if (h < height) this
      else {
        val top = elem(' ', width, (h - height) / 2)
        val bottom = elem(' ', width, h - height - top.height)
        top above this above bottom
      }
    }

    override def toString = contents mkString "\n"
  }


  object Element {
    private class ArrayElement(val contents: Array[String]) extends Element {

    }

    private class LineElement(s: String) extends Element {
      override def contents = Array(s)
      override def width: Int = s.length
      override def height: Int = 1
    }

    private class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
      private val line = ch.toString * width
      override val contents = Array.fill(height)(line)
    }
    def elem(contents: Array[String]): Element = new ArrayElement(contents)
    def elem(str: String): Element = new LineElement(str)
    def elem(ch: Char, height: Int, width: Int): Element = new UniformElement(ch, height, width)
  }

  def main(args: Array[String]) {
    val e1 = Element.elem(Array("2kl", "shslls"))
    val e2 = Element.elem(Array("Hello"))
    val e3 = e1 above e2
    println(e3)
  }
}

