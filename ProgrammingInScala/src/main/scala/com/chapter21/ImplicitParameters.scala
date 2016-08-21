package com.chapter21

import scala.sys.process._

/**
  * Created by lgrcyanny on 16/7/16.
  */
object ImplicitParameters {

  case class PreferredPrompt(val preference: String)
  case class PreferredDrink(val drink: String)

  object Greet {
    implicit val prompt = PreferredPrompt("!")
    implicit val drink = PreferredDrink("beer")
    def greet(msg: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink): Unit = {
      println(s"Hello: $msg")
      println(prompt.preference)
      println(drink.drink)
    }
  }

  def maxListImpPrm[T](xs: List[T])(implicit ordered: T => Ordered[T]): T = {
    xs match {
      case Nil => throw new IllegalArgumentException("Empty List")
      case List(x) => x
      case x :: xs1 =>
        val maxRest = maxListImpPrm(xs1)
        if (ordered(x) > maxRest)
          x
        else
          maxRest
    }
  }

  def maxListImpPrmWithViewBound[T <% Ordered[T]](xs: List[T]): T = {
    xs match {
      case Nil => throw new IllegalArgumentException("Empty List")
      case List(x) => x
      case x :: xs1 =>
        val maxRest = maxListImpPrm(xs1)
        if (x > maxRest)
          x
        else
          maxRest
    }
  }

  def main(args: Array[String]) {
    println(maxListImpPrm(List(1, 2, 3)))
  }
}
