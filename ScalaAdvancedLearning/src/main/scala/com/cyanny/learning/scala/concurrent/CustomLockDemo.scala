package com.cyanny.learning.scala.concurrent

object CustomLockDemo {

  object Lock {
    var lockCount = 0
    def lock(): Unit = {
      while (lockCount > 0) {}
      lockCount = lockCount + 1
    }

    def unLock(): Unit = {
      lockCount = lockCount - 1
    }
  }

}
