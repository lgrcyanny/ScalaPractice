package com.chapter29

import scala.collection.immutable.HashSet

/**
  * Created by lgrcyanny on 17/1/11.
  */
object EqualityTest {
  case class Point(var x: Int, var y: Int) {
    override def equals(obj: scala.Any): Boolean = {
      obj match {
        case p: Point =>
          this.x == p.x && this.y == p.y
        case _ => false
      }
    }
    override def hashCode(): Int = 41 * (41 + x) + y
  }

  def main(args: Array[String]): Unit = {
    val p1, p2 = Point(2, 3)
    val set = new HashSet[Point]
    val aSet = set + p1
    println(aSet.contains(p2))
    p1.x += 1
    println(aSet.contains(p2))
    println(aSet.iterator.contains(p2))
  }
}
