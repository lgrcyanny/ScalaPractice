package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/6/4.
  */
object ToMapOrNotToMap {
  case class RomanNumeral(symbol: String, value: Int)
  implicit object RomanOrdering extends Ordering[RomanNumeral] {
    def compare(a: RomanNumeral, b: RomanNumeral) =
      a.value compare  b.value
  }
  import collection.immutable.SortedSet
  val numerals = SortedSet(
    RomanNumeral("M", 1000),
    RomanNumeral("C", 100),
    RomanNumeral("X", 10),
    RomanNumeral("I", 1),
    RomanNumeral("D", 500),
    RomanNumeral("L", 50),
    RomanNumeral("V", 5)
  )

  def process() = {
    println("Roman numeral symbols for 1 5 10 50 100 500 1000:")
    for (num <- numerals; sym = num.symbol) println(s"$sym")
    println("Roman numeral symbols for 1 5 10 50 100 500 1000:")
    numerals.map(_.symbol).foreach(println)
  }

  def main(args: Array[String]): Unit = {
    process()
  }
}
