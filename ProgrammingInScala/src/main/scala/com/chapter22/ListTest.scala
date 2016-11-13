package com.chapter22

/**
  * Created by lgrcyanny on 16/7/19.
  */
object ListTest {

  final case class $$ (x: Int, y: Int) {
    def result = x + y
  }

  val x = List(1, 2)
}
