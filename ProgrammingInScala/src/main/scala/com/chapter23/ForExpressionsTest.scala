package com.chapter23

/**
  * Created by lgrcyanny on 16/8/3.
  */
object ForExpressionsTest {

  case class Person(name: String, isMale: Boolean, children: Person*)

  def prepare() = {
    val bob = Person("Bob", true)
    val lucy = Person("Lucy", false, bob)
    val lily = Person("Lily", false, bob, lucy)
    List(bob, lucy, lily)
  }

  def query() = {
    val persons = prepare()
    val children: List[Person] = for (p <- persons if !p.isMale; child <- p.children) yield child
    println(children)
  }

  def anotherTest() = {
    val persons = List("Lily", "Lucy", "John")
    val filtered = for {
      p <- persons
      x = p
      if x.startsWith("L")
    } yield p
    println(filtered)
  }

  def main(args: Array[String]) {
    anotherTest()
  }

}
