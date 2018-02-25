package com.learning.puzzlers

import collection.mutable
/**
  * Created by lgrcyanny on 17/12/18.
  */
object SizeItUp {
  def howManyItems(lunchbox: mutable.Set[String], itemToAdd: String): Int = (lunchbox + itemToAdd).size

  def howManyItemsRefac(lunchbox: mutable.Iterable[String], itemToAdd: String): Int = {
//    val sizedUpBox: mutable.Iterable[String] = (lunchbox + itemToAdd) // diable implicit
    (lunchbox + itemToAdd).size
  }

  val lunchbox = mutable.Set("chocolate bar", "orange juice", "sandwich")

  def main(args: Array[String]): Unit = {
    println(howManyItems(lunchbox, "apple"))
    println(howManyItemsRefac(lunchbox, "apple"))
    println(lunchbox.size)
  }
}
