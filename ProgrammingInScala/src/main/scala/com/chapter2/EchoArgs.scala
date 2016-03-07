package com.chapter2

/**
 * Created by lgrcyanny on 16/1/19.
 */
// scala -cp target/programming-in-scala-1.0-SNAPSHOT.jar chapter2.EchoArgs scala is fun
object EchoArgs {

  def main(args: Array[String]) {
    var i = 0;
    while (i < args.size) {
      if (i != 0) {
        print(" ")
      }
      print(args(i))
      i += 1
    }
    println()
  }
}
