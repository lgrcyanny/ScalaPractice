package com.cyanny.learning.scala.concurrent

object PetersonLockDemo {

  class PetersonLock {
    val flag = Array(false, false)
    var victim: Int = 0
    def lock(): Unit = {
      val i = Thread.currentThread().getId.toInt
      val j = 1 - i % 2
      flag(i) = true
      victim = i
      while (flag(j) && victim == i) {}
    }

    def unLock(): Unit = {
      val i = Thread.currentThread().getId.toInt
      flag(i % 2) = false
    }
  }

}
