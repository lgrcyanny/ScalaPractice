val data: List[Int] = List(1, 2, 3, 4, 5, 6, 7)

def sum(xs: List[Int]) = xs reduceLeft(_ + _)

def sum2(xs: List[Int]) = (xs foldLeft 0)(_ + _)

sum2(data)

// Only right weith foldRight
def concat(xs: List[Int], ys: List[Int]) =
  (xs foldRight ys)(_ :: _)

val l1 = List(1, 2)
val l2 = List(3, 4)
concat(l1, l2)

// Only right with foldLeft
def reverse[T](xs: List[T]): List[T] =
  (xs foldLeft List[T]())((xs, x) => x :: xs)
reverse(data)

// Only right with foldRight
def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())((x, xs) => f(x) :: xs)

mapFun(data, (x: Int) => x * 2)

// right both with foldRight and foldLeft
def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)((x, c) => c + 1)
lengthFun(data)

def lengthFun2[T](xs: List[T]): Int =
  (xs foldLeft 0)((c, x) => c + 1)
lengthFun2(data)



