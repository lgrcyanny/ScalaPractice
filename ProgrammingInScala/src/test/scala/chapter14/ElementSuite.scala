package chapter14

import org.scalatest.{FunSuite, Suite}

/**
 * Created by lgrcyanny on 16/3/28.
 */
object Element {
  def show(n: Int) = if (n > 0) n else throw new IllegalArgumentException
}

class ElementSuite extends FunSuite {

  test("test element show") {
    intercept[IllegalArgumentException] {
      Element.show(-9)
    }
  }

}
