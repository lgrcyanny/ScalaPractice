package com.chapter9

import java.io.{PrintWriter, File}

import scala.io.Source

/**
 * Created by lgrcyanny on 16/3/3.
 */
object LoanPattern {
  def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def main(args: Array[String]) {
    println(getClass.getClassLoader.getResource("test.txt").getPath)
    val file = new File(getClass.getClassLoader.getResource("test.txt").getPath)
    withPrintWriter(file){
      writer =>
        writer.println(Source.fromFile(file).getLines())
    }
  }
}
