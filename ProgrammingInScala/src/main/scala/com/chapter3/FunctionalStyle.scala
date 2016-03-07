package com.chapter3

/**
 * Created by lgrcyanny on 16/1/22.
 */
object FunctionalStyle {
  // not purely functional, print to stdout, has side effects
  def printArgs(args: Array[String]): Unit = {
    args.foreach(println)
  }
  // purely functional, has no side effects
  def formatArgs(args: Array[String]): String = args.mkString("\n")
  def main(args: Array[String]) = {
    println(formatArgs(args))
  }
}
