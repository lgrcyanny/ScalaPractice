abstract class IntSet {
  def contains(x: Int): Boolean
  def incl(x: Int): IntSet
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
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

  def union(other: IntSet) =
    left.union(right.union(other.incl(elem)))
    //((left union right) union other) incl elem

  override def toString = "{" + left + elem + right + "}"
}

val n1 = new NonEmpty(3, Empty, Empty)
val n2 = new NonEmpty(1, Empty, Empty)
val n3 = new NonEmpty(5, Empty, Empty)
val n4 = new NonEmpty(4, Empty, Empty)
n1 union n2 union n3 union n4 // The tree is not balance








