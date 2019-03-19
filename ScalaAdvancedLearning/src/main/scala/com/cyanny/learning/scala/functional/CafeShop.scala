package com.cyanny.learning.scala.functional

object CafeShop {

  case class Charge(card: Long, amount: Double) {
    def combine(other: Charge): Charge = {
      if (card == other.card) {
        Charge(card, amount + other.amount)
      } else {
        throw new Exception("can't combine two different card")
      }
    }
  }

  case class Coffee(name: String, price: Double)

  def byCoffee(card: Long, coffee: Coffee): Charge = {
    Charge(card, coffee.price)
  }

}
