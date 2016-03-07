package com.chapter9

import java.io.File

/**
 * Created by lgrcyanny on 16/3/2.
 */
object HigherOrderFunctions {
  def filesHere = new File(".").listFiles()

  def filesMatching(matcher: (String) => Boolean) = {
    for (file ← filesHere if matcher(file.getName)) yield file
  }

  def filesRegex(query: String) = filesMatching(_.matches(query))

  def main(args: Array[String]) {
    val matchedFiles = filesRegex("\\*\\.\\*").map(_.getAbsolutePath).toList
    println(matchedFiles.mkString("\n"))
  }
}
