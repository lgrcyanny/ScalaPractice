def msort(xs: List[Int]): List[Int] = {
  val n = xs.length / 2
  if (n == 0) {
    xs
  } else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (p :: ps, q :: qs) => {
        if (p < q) p :: merge(ps, ys)
        else q :: merge(xs, qs)
      }
    }
    val (left, right) = xs splitAt n
    merge(msort(left), msort(right))
  }
}

msort(List(9, 8, 7, 16, 1, 2, 3, 0, 12))
