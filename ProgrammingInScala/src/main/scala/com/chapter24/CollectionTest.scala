package com.chapter24

import scala.collection.BitSet
import scala.collection.immutable.TreeSet

/**
  * Created by lgrcyanny on 16/9/7.
  */
object CollectionTest {
  def fib(m: Int, n: Int): Stream[Int] = m #:: fib(n, m + n)

  def evenElems[T: ClassManifest](xs: Vector[T]): Array[T] = {
    val arr = new Array[T]((xs.length + 1) / 2)
    for (i <- 0 until xs.length by 2) {
      arr(i / 2) = xs(i)
    }
    arr
  }

  def main(args: Array[String]): Unit = {
    // test tree set
    val ordering = Ordering.fromLessThan[Int](_ < _)
    val treeSet = TreeSet.empty(ordering)
    val numbers = treeSet + (1, 4, 5, 6, 1, 3, 4)
    println(numbers)

    val fibList = fib(1, 1).take(10).toList
    println(fibList)

    val bitset = BitSet.empty
    val moreBits = bitset + 1 + 3 + 5+ 6 + 1
    println(moreBits)

    val evenElements = evenElems(Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    println(evenElements.toList)

    val emptyStack = scala.collection.immutable.Stack.empty
    val hasOne = emptyStack.push(1)
  }
}
