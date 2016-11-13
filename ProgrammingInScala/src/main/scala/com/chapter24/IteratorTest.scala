package com.chapter24

/**
  * Created by lgrcyanny on 16/11/13.
  */
object IteratorTest {
  def fun() = {
    val it = Iterator("a", "number", "for", "length")
    val aIt = it.map(_.length)
    aIt.foreach(println)

    val (iter1, iter2) = it.duplicate
//    it.next() throw no such element exception
    val newIt = aIt.grouped(4)
    newIt.foreach(println)
  }

  def fun2() = {
    val it = Iterator("a", "number", "for", "length")
    val newIt = it.filter(_.contains("r"))
    newIt.foreach(println)
    try{
      it.next()
    } catch {
      case e: NoSuchElementException =>
        println("Got NoSuchElementException")
    }
  }

  def fun3() = {
    val it = Iterator("a", "number", "for", "length")
    it.patch(0, Iterator("a", "b", "c"), 1) foreach(println)
  }

  def skipEmptyString() = {
    val itr = Iterator("", "a", "non empty", "string")
    val bufferedItr = itr.buffered
    while(bufferedItr.head.isEmpty) {
      bufferedItr.next()
    }
    bufferedItr.foreach(println)
  }

  def main(args: Array[String]): Unit = {
    fun()
    fun2()
    fun3()
    skipEmptyString()
  }
}
