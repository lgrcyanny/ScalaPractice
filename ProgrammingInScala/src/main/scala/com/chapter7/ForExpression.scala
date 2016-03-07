package com.chapter7

import java.io.File

import scala.io.Source

/**
 * Created by lgrcyanny on 16/2/23.
 */
object ForExpression {

  def grep(pattern: String, path: String) = {
    val files = new File(path).listFiles()
    for {
      file ← files
      if file.getName.endsWith(".scala")
      line ← Source.fromFile(file).getLines()
      trimmed = line.trim
      if trimmed.matches(pattern)
    } println(file + ": " + trimmed)
  }

  def main(args: Array[String]) {
    grep("grep.*", "src/main/scala/com/chapter7")
  }
}
