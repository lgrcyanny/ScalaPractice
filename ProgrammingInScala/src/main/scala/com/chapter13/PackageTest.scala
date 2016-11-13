package com.chapter13

/**
 * Created by lgrcyanny on 16/3/18.
 */
package fruit
object Fruit {
  def showName() = println("fruit")
}

object Banana {
  def slice() = println("slice banana")
}

package object bobsdelights {
  def showFruits = println("I have many fruits")
}

object PackageTest {
  def main(args: Array[String]) {
    // to hide Banana
    import com.chapter13.fruit.{Banana=>_, _}
    bobsdelights.showFruits

  }

}
