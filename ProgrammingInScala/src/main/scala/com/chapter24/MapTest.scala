package com.chapter24

import scala.collection.mutable

/**
  * Created by lgrcyanny on 16/9/26.
  */
object MapTest {

  def main(args: Array[String]): Unit = {
    val maps = mutable.Map("k1" -> "v1", "k2" -> "v2")
    println(maps.getOrElse("k3", "v3"))
  }

}
