import scala.math.Ordering
def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2
  if (n == 0) {
    xs
  } else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) => {
        if (ord.lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
      }
    }
    val (left, right) = xs splitAt n
    merge(msort(left), msort(right))
  }
}

val nums = List(-4, 7, 1, -5, 7, 9)
val words = List("today", "world", "aha", "blalal", "ahsst")
msort(nums)
msort(words)
