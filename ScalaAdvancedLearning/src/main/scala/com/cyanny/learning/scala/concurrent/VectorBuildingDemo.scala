package com.cyanny.learning.scala.concurrent

import java.util

import scala.collection.mutable

object VectorBuildingDemo {

  val vector = new util.Vector[Int]()

  def process(): Unit = {
    vector.synchronized {
      (0 until vector.size()).foreach { i =>
        println(vector.get(i))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    (1 to 10).foreach { i =>
      vector.add(i)
    }
    process()
  }

}
