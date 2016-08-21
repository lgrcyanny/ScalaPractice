package com.chapter21

/**
  * Created by lgrcyanny on 16/7/11.
  */
object ImplicitConversions {
  case class Person(id: Int)
  implicit def intToPerson(a: Int) = Person(a)

  def printPerson(person: Person) = println(person)
  Predef
  implicit def doubleToInt(x: Double) = x.toInt

  def main(args: Array[String]) {
    import ImplicitConversions._
//    val x: Int = 9.8
//    printPerson(x)
  }
}
