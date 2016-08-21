package com.chapter23

import scala.collection.mutable.ArrayBuffer

/**
  * Created by lgrcyanny on 16/8/21.
  */
object EightQueens {
  type Row = Int
  type Column = Int

  /**
    * the coordinates of the queen in row k comes first in each List[(ROW, Column)], followed
    * by k -1, k - 2, ..., 0 and so on
    *
    * @param n
    * @return
    */
  def queens(n: Int): Set[List[(Row, Column)]] = {
    def placeQueen(k: Int): Set[List[(Row, Column)]] = {
      if (k < 0) {
        Set(List())
      } else {
        for {
          queens <- placeQueen(k - 1)
          column <- 0 until n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens
      }

    }

    def isSafe(queen: (Row, Column), queens: List[(Row, Column)]): Boolean = {
      queens.forall { placedQueen =>
        placedQueen._1 != queen._1 &&
          placedQueen._2 != queen._2 &&
          (Math.abs(placedQueen._1 - queen._1) !=
            Math.abs(placedQueen._2 - queen._2))
      }
    }
    placeQueen(n - 1)
  }

  def printQueens(n: Int, solutions: Set[List[(Row, Column)]]) = {
    for (queens <- solutions) {
      println("======================================")
      for (row <- 0 until n) {
        val buffer = new ArrayBuffer[String]()
        for (column <- 0 until n) {
          if (queens.contains((row, column))) {
            buffer.append("1")
          } else {
            buffer.append("*")
          }
        }
        println(buffer.mkString(" "))
      }
    }
  }

  def main(args: Array[String]) {
    val res = queens(8)
    printQueens(8, res)
    println(s"Solutions: ${res.size}")
  }

}
