object session4_variance {
  // Make List covariant, so that Nil can be object
  trait List[+T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
    def prepend[U >: T](elem: U): List[U] = new Cons(head, this)
  }

  object Nil extends List[Nothing] {
    def isEmpty: Boolean = true
    def head: Nothing = throw new NoSuchElementException("Nil.head")
    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
    override def toString = ""
  }

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty: Boolean = false
    override def toString = head + ", " + tail
  }

  abstract class IntSet {
    def contains(x: Int): Boolean
    def incl(x: Int): IntSet
    def union(other: IntSet): IntSet
  }

  class Empty extends IntSet {
    def contains(x: Int): Boolean = false
    def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
    def union(other: IntSet) = other
    override def toString = "."
  }

  // Organized as binary search tree
  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def contains(x: Int): Boolean = {
      if (x < elem) left contains x
      else if (x > elem) right contains x
      else true
    }

    def incl(x: Int): IntSet = {
      if (x < elem) new NonEmpty(elem, left incl x, right)
      else if (x > elem) new NonEmpty(elem, left, right incl x)
      else this
    }

    def union(other: IntSet): IntSet =
      ((left union right) union other) incl elem

    override def toString = "{" + left + elem + right + "}"
  }

  object test {
    val x: List[String] = Nil
    def f(xs: List[NonEmpty], s: Empty): List[IntSet] = xs.prepend(s)
  }
}