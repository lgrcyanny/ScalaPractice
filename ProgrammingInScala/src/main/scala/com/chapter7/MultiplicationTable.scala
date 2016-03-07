package com.chapter7

/**
 * Created by lgrcyanny on 16/2/24.
 */
object MultiplicationTable {
  def makeRowSeq(row: Int) = {
    for (i ← 1 to 10) yield {
      val prod = (i * row).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }
  }
  def makeRow(row: Int) = makeRowSeq(row).mkString

  def multiTable() = {
    (for (i ← 1 to 10) yield makeRow(i)).mkString("\n")
  }

  def main(args: Array[String]) {
    val table = multiTable()
    println(table)
  }
}
