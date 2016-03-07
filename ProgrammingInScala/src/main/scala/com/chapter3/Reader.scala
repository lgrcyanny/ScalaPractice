package com.chapter3

import scala.io.Source

/**
 * Created by lgrcyanny on 16/1/26.
 */
object Reader {
  def widthOfLength(s: String) = s.length.toString.length

  def load(fileName: String) = {
    val lines = Source.fromFile(fileName).getLines().toList
    val longestLine: String = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
    val maxWidth = widthOfLength(longestLine)
    for (line ← lines) {
      val numSpaces = maxWidth - widthOfLength(line)
      val padding = " " * numSpaces
      println(padding + line.length + " | " + line)
    }
  }

  def main(args: Array[String]) {
    if (args.size == 1) {
      load(args(0))
    } else {
      Console.err.println("Please give file name")
    }

  }
}
