package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = (x: Int) => x > 10
    val s5 = (x: Int) => x < -10
    val s6 = (x: Int) => (x >= -10) && (x <= 10)
    val s7 = (x: Int) => (x >= 8) && (x <= 15)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect element") {
    new TestSets {
      val s = intersect(s6, s7)
      assert(contains(s, 8), "Intersect set contains 8")
      assert(contains(s, 9), "Intersect set contains 9")
      assert(contains(s, 10), "Intersect set contains 10")
      assert(!contains(s, 7), "Intersect set doesn't contain 7")
      assert(!contains(s, 11), "Intersect set doesn't contain 11")
    }
  }

  test("intersect result is empty") {
    new TestSets {
      val s = intersect(s1, s7)
      for (i <- 1 to 15) {
        assert(!contains(s, i), "Empty insertect set")
      }
    }
  }

  test("diff element") {
    new TestSets {
      val s = diff(s6, s7)
      for (i <- -10 to 7) {
        assert(contains(s, i), "Diff set contains " + i)
      }
      for (i <- 8 to 10) {
        assert(!contains(s, i), "Diff set doesn't contains " + i)
      }
    }
  }

  test("filter element") {
    new TestSets {
      info("Filter set -10~10 with even numbers")
      val s = filter(s6, x => x % 2 == 0)
      for (i <- -10 to 10 if i % 2 == 0) {
        assert(contains(s, i), "Filtered even numbers set contains " + i)
      }
    }
  }

  test("forall query") {
    new TestSets {
      val s = union(union(s1, s2), s3)
      assert(forall(s, x => x > 0))
    }
  }

  test("exist query") {
    new TestSets {
      val s = union(s6, s7)
      info("Test there is at least one element can be devided by 3")
      assert(exists(s, x => x % 3 == 0))
    }
  }

  test("map transformation") {
    new TestSets {
      val s = map(union(s2, s3), x => x * x)
      assert(contains(s, 4), "map result contains 4")
      assert(contains(s, 9), "map result contains 9")
      assert(!contains(s, 2), "map result doesn't contain 2")
      assert(!contains(s, 3), "map result doesn't contain 3")
    }
  }
}
