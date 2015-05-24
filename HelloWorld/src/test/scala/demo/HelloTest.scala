package demo

import org.scalatest.FunSuite

/**
 * Created by lgrcyanny on 15/5/17.
 */
class HelloTest extends FunSuite {
  test("Say hello works correctly") {
    val hello = new Hello
    assert(hello.sayHello("Scala") == "Hello Scala!")
  }
}
