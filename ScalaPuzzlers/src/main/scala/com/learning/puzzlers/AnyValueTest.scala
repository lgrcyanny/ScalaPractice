package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/11/4.
  */
object AnyValueTest {
  trait Recipe {
    type T <: AnyVal
    def sugarAmount: T
    def howMuchSugar(): Unit = {
      println(s"Add ${sugarAmount} tablespoons of sugar")
    }
  }

  trait NutritionalInfo {
    type T <: AnyVal
    var value: T = _
  }

  def main(args: Array[String]): Unit = {
    val approxCake = new Recipe {
      type T = Int
      override def sugarAmount = 4
    }
    approxCake.howMuchSugar()

    val gourmetCake = new Recipe {
      override type T = Double
      override def sugarAmount = 5.21
    }
    gourmetCake.howMuchSugar()

    val containsSugar = new NutritionalInfo {
      override type T = Boolean
    }
    println(s"${containsSugar.value}")
    println(s"${!containsSugar.value}")
  }

}
