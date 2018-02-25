package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/12/14.
  */
object AListfulOfDollars {

  def process() = {
    type Dollar = Int
    val dollar: Dollar = 1
    val x: List[Dollar] = List(1, 2, 3)
    println(x map {x: Int => dollar})
//    println(x.map(x: Int => dollar)) // compile error
    println(x.map((x: Int) => dollar))
  }

  def main(args: Array[String]): Unit = {
    process()
  }

}
