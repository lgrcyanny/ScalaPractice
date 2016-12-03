package com.chapter25

/**
  * Created by lgrcyanny on 16/11/27.
  */
object RNABases {
  abstract class Base
  object A extends Base
  object T extends Base
  case object G extends Base
  case object U extends Base

  object Base {
    val fromInt: Int => Base = Array(A, T, G, U)
    val toInt: Base => Int = Map(A -> 0, T -> 1, G -> 2, U -> 3)
  }

  def main(args: Array[String]): Unit = {
    val v: (Base) => Int = Base.toInt
    println(v.toString())
  }

}
