package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/5/17.
  */
object InitYouInitMe {

  object X {
    val value: Int =  Y.value + 1
  }

  object Y {
    val value: Int = X.value + 1
  }

  object XY {
    val xvalue: Int = yvalue + 1
    val yvalue: Int = xvalue + 1
  }

  def main(args: Array[String]): Unit = {
    if (Math.random() > 0.5) println(X.value) else println(Y.value)
    println(XY.xvalue)
  }

}
