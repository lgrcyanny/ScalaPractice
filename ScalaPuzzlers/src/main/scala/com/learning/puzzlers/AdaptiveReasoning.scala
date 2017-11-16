package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/10/7.
  */
object AdaptiveReasoning {
  def mod(a: => Double) = if (a > 0) -a else a

  class Printer(prompter: => Unit) {
    def print(message: String, prompted: Boolean = false) = {
      if (prompted) prompter
      println(message)
    }
  }

  def prompt() = {
    print("Puzzler$ ")
  }

  def main(args: Array[String]): Unit = {
    mod({println("evaluating"); 5.2})
    new Printer{prompt} print (message = "Puzzled yet?")
    new Printer{prompt} print (message = "Puzzled yet?", prompted = true)
  }

}
