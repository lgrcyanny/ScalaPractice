package com.chapter20

/**
  * Created by lgrcyanny on 16/6/30.
  */
trait Abstract {
  type T
  def process(x: T): T
  val init: T
  var content: T
}


class Conceret extends Abstract {
  type T = String
  def process(x: T): T = {
    println(x)
    x
  }
  val init: T = "Hello"
  var content: T = _
}

object Animals {
  class Food
  abstract class Animal {
    type SuitableFood <: Food
    def eat(food: SuitableFood)
  }

  class Meat extends Food
  class Dog extends Animal {
    type SuitableFood = Meat
    def eat(food: SuitableFood) = {
      println("Eating food")
    }
  }

  def main(args: Array[String]) {
    val d = new Dog
    d.eat(new Meat)
  }
}
