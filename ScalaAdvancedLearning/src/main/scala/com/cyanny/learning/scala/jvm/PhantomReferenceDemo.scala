package com.cyanny.learning.scala.jvm

import scala.ref.{PhantomReference, ReferenceQueue}

object PhantomReferenceDemo {

  class MyObject {
    var meta = "metadata"

    override def finalize(): Unit = {
      println("finalize resource")
    }

    override def toString: String = meta
  }


  def process() = {
    val referenceQueue = new ReferenceQueue[MyObject]()
    var myObject = new MyObject
    val ref = new PhantomReference(myObject, referenceQueue)
    myObject = null
    for (i <- 1 to 100) {
      System.gc()
    }
    var isRun = true
    while (isRun) {
      val obj = referenceQueue.poll
      if (obj.isDefined) {
        println(s"obj from reference queue: ${obj}")
        isRun = false
      } else {
        println("no element")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    process()
  }

}
