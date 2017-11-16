package com.learning.puzzlers

import java.util

/**
  * Created by lgrcyanny on 17/9/18.
  */
object CastAway {
  import scala.collection.JavaConverters._

  def javaMap: java.util.HashMap[String, java.lang.Integer] = {
    val map = new util.HashMap[String, java.lang.Integer]()
    map.put("key", null)
    map
  }

  def main(args: Array[String]): Unit = {
    val scalaMap = javaMap.asScala
    val scalaTypesMap = scalaMap.asInstanceOf[scala.collection.Map[String, Int]]
    println(scalaTypesMap.get("key"))
    println(scalaTypesMap("key") == 0)
  }


}
