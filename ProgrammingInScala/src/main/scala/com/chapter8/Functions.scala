package com.chapter8

import scala.io.{BufferedSource, Source}

/**
 * Created by lgrcyanny on 16/2/26.
 */
object LongLines {

  def readFile(fileName: String, width: Int) = {
    val file: BufferedSource = Source.fromFile(fileName)
    for (line ← file.getLines())
      processLine(fileName, line, width)
  }

  def processLine(fileName: String, line: String, width: Int) = {
    if (line.length > width) {
      println(s"$fileName, $width: $line")
    }
  }

  def main(args: Array[String]) {
    val width = args(0).toInt
    for (arg ← args.drop(1))
      readFile(arg, width)
  }

}
