package com.chapter8
import scala.collection.immutable.Stream
/**
 * Created by lgrcyanny on 16/3/1.
 */
object Test {
  def main(args: Array[String]) {
    lazy val fibs: Stream[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map(n => n._1 + n._2)
    println(fibs take 5 toList)
  }
}
