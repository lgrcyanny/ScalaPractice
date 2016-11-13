package com.chapter24

import scala.collection.immutable.Stream
/**
  * Created by lgrcyanny on 16/10/19.
  */
object StreamTest {
  val s = 1 #:: 2 #:: 3 #:: Stream.empty
}
