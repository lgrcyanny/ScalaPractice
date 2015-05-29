object session1_more_functions_on_lists {
  // O(n)
  def last[T](xs: List[T]): T = xs match {
    case Nil => throw new NoSuchElementException("Last for empty list")
    case List(x) => x
    case y :: ys => last(ys)
  }
  last(List(1, 2, 3, 4, 5, 6))

  // O(n)
  def init[T](xs: List[T]): List[T] = xs match {
    case Nil => throw new Error("empty list init")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }
  init(List(3, 4, 5, 6, 7, 8))

  // O(|xs|) |xs| stands for length of xs
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil => ys
    case p :: ps => p :: concat(ps, ys)
  }
  val a = List(1, 2)
  val b = List(3, 4)
  concat(a, b)

  // O(n * n)
  def reverse[T](xs: List[T]): List[T] = xs match {
    case Nil => List()
    case y :: ys => reverse(ys) ++ List(y)
  }
  reverse(a)

  // O(n)
  def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
    case Nil => xs
    case y :: ys => {
      if (n >= 0 && n < xs.length) {
        if (xs(n) == y) ys else y :: removeAt(n - 1, ys)
      } else {
        y :: ys
      }
    }
  }
  val c = List(1, 2, 3, 4, 5)
  removeAt(6, c)

  def removeAt2[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)
  removeAt(6, c)
}