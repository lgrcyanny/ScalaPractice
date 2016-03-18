package com.chapter12

/**
 * Created by lgrcyanny on 16/3/14.
 */
trait Philosophical {
  def philosophize(): Unit = {
    println("I consume memory, therefore I am!")
  }

  def printToString(): Unit = {
    println(super.toString)
  }
}

abstract class Animal {
  override def toString = "It is animal"
}


class Frog extends Animal with Philosophical {
  override def toString = "Frog"
}

object Test {
  def main(args: Array[String]) {
    val phil: Philosophical = new Frog
    phil.philosophize()
    phil.printToString()
  }
}