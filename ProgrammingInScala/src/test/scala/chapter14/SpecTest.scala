package chapter14

import org.scalatest._
import org.scalatest.prop.Checkers


import scala.collection.mutable


/**
 * Created by lgrcyanny on 16/3/28.
 */
class SpecTest extends WordSpec with Matchers with Checkers {
  val stack = new mutable.Stack[Int]()
  "A stack" should {
    "stack should pop the first" in {
      stack.push(1)
      stack.push(2)
      stack.pop() should be (2)
    }

    case class Element(e: Int)

//    "test with scala check" in {
//      check((a: List[Int], b: List[Int]) => a.size + b.size == (a ::: b).size)
//    }
  }


}
