package com.cyanny.learning.scala.concurrent

import scala.collection.concurrent.TrieMap

object LockExample {

  val dataObject = new TrieMap[String, Any]()

  def main(args: Array[String]): Unit = {
    dataObject.synchronized {
      println("Lock level one")
      dataObject.synchronized {
        println("Lock level two")
      }
    }
  }

}
