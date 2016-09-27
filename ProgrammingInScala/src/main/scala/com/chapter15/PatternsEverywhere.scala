package com.chapter15

/**
 * Created by lgrcyanny on 16/4/12.
 */
object PatternsEverywhere {
  val myTuple = (123, "121")
  val (number, string) = myTuple

  case class Person(name: String, age: Int)
  val p = Person("lubcy", 12)
  val Person(name, age) = p

//  val second: PartialFunction[List[Int], Int] = {
//    case x :: y :: _ => y
//    case Nil => 0
//  }
//  val first: List[Int] => Int = {
//    case x :: y :: _ => x
//    case Nil => 0
//  }

  def withDefault: Option[Int] => Int = {
    case Some(x) if x < 0 => Math.abs(x)
    case None => 0
  }

  def main(args: Array[String]) {
    val x = withDefault(Some(-3))
//    println(second.isDefinedAt(List(1)))
  }


}
