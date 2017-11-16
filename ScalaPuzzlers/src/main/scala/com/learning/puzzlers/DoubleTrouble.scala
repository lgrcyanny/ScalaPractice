package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/10/9.
  */
object DoubleTrouble {

  def printSorted(a: Array[Double]) = {
    scala.util.Sorting.stableSort(a)
    println(a.mkString(" "))
  }

  def printSortedByDoubleCompare(a: Array[Double]) = {
    def compare(x: Double, y: Double) = (x compare y) < 0
    scala.util.Sorting.stableSort(a, compare _)
    println(a.mkString(" "))
  }

  def main(args: Array[String]): Unit = {
    printSorted(Array(7.89, Double.NaN, 1.23, 4.56))
    printSorted(Array(7.89, 1.23, Double.NaN, 4.56))
    printSortedByDoubleCompare(Array(7.89, 1.23, Double.NaN, 4.56))
    println(1.0 < Double.NaN) // false
    println(7.89 < Double.NaN) // false
  }

}
