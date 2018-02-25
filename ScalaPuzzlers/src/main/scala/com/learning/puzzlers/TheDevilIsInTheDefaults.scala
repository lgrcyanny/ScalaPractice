package com.learning.puzzlers

import scala.collection.mutable

/**
  * Created by lgrcyanny on 17/12/11.
  */
object TheDevilIsInTheDefaults {

  def process() = {
    val accBalances: mutable.Map[String, Int] = mutable.Map() withDefaultValue(100)
    def transaction(accHolder: String, amount: Int, accounts: mutable.Map[String, Int]) = {
      accounts += accHolder -> (accounts(accHolder) + amount)
    }
    // The error way
    //  val accBalancesWithHist: mutable.Map[String, mutable.Buffer[Int]] = mutable.Map() withDefaultValue { mutable.Buffer(100) }
    val accBalancesWithHist: mutable.Map[String, mutable.Buffer[Int]] = mutable.Map() withDefault { _ => mutable.Buffer(100) }
    def transactionWithHist(accHolder: String, amount: Int, accounts: mutable.Map[String, mutable.Buffer[Int]]): Unit = {
      val newAmount = accounts(accHolder).head + amount
      accounts += accHolder -> (newAmount +=: accounts(accHolder))
    }

    transaction("Alice", -100, accBalances)
    println(accBalances("Alice"))
    println(accBalances("Bob"))
    transactionWithHist("Dave", -100, accBalancesWithHist)
    println(accBalancesWithHist("Carol").head)
    println(accBalancesWithHist("Dave").head)
  }

  def main(args: Array[String]): Unit = {
    process()
  }

}
