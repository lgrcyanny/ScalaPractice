package com.chapter29


/**
  * Created by lgrcyanny on 17/1/22.
  */
object EqualityTestForTree {
  trait Tree[+T] {
    def elem: T
    def left: Tree[T]
    def right: Tree[T]
  }

  object EmptyTree extends Tree[Nothing] {
    override def elem: Nothing = throw new NoSuchElementException("EmptyTree.elem")

    override def left: Tree[Nothing] = throw new NoSuchElementException("EmptyTree.left")

    override def right: Tree[Nothing] = throw new NoSuchElementException("EmptyTree.right")

    override def equals(obj: scala.Any): Boolean = true
  }

  class Branch[+T](val elem: T, val left: Tree[T], val right: Tree[T]) extends Tree[T] {
    override def equals(obj: scala.Any): Boolean = obj match {
      case that: Branch[_] => (that canEqual this) &&
        this.elem == that.elem &&
        this.left == that.elem &&
        this.right == that.right
      case _ => false
    }

    def canEqual(other: Any) = other.isInstanceOf[Branch[_]]
    override def hashCode: Int =
      41 * (
        41 * (
          41 + elem.hashCode
          ) + left.hashCode
        ) + right.hashCode

  }

  def main(args: Array[String]): Unit = {
    val b1 = new Branch[String]("a1", EmptyTree, EmptyTree)
    val b2 = new Branch[String]("a1", EmptyTree, EmptyTree)
    println(b1.hashCode)
    println(b1 == b2)
  }

}
