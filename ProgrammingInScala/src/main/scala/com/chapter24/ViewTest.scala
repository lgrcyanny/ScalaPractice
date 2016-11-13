package com.chapter24

/**
  * Created by lgrcyanny on 16/11/10.
  */
object ViewTest {
  def test1()  = {
    val v = Vector(1 to 10: _*)
    val new_view = v.view.map(_ + 1).map(_ * 2).force
    println(new_view)
  }

  def findPalindrome(s: Seq[String]): Option[String] = {
    def isPalindrome(x: String) = x == x.reverse
    s find isPalindrome
  }

  def arrayTest() = {
    val arr = Array(1 to 10: _*)
    val subArr = arr.view.slice(3, 6)
    subArr(0) = -1
    println(arr.toList)
  }

  case class People(name: String)

  def main(args: Array[String]): Unit = {
    test1()
    arrayTest()
  }
}
