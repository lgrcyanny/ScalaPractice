def scaleList(xs: List[Double], factor: Double): List[Double] =
  xs map (x => x * factor)

val nums = List(1.2, 2.3, 4.5, 5.1)
scaleList(nums, 2)


def squareList(xs: List[Int]): List[Int] = xs match {
  case Nil => Nil
  case x :: xs => x * x :: squareList(xs)
}

def squareListWithMap(xs: List[Int]): List[Int] =
  xs map (x => x * x)

val ints = List(5, 6, 1, 2, 3, 4, -8)

squareList(ints)
squareListWithMap(ints)

def filter[T](xs: List[T], p: T => Boolean): List[T] = xs match {
  case Nil => xs
  case y :: ys => if (p(y)) y :: filter(ys, p) else filter(ys, p)
}

filter(ints, (x: Int) => x > 2)
ints filter (x => x > 2)
ints partition (x => x > 2)
ints takeWhile (x => x > 2)
ints dropWhile (x => x > 2)
ints span (x => x > 2)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (first, rest) = xs span (y => y == x)
    first :: pack(rest)
}
val chars = "aaabcca".toList
pack(chars)

def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs) map (ys => (ys.head, ys.length))
encode(chars)

