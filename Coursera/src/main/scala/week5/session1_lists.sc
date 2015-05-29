def sum(xs: List[Int]): Int = xs match {
  case x :: tail => x + sum(tail)
  case Nil => 0
}

sum(List(1, 2, 3, 4))

val a = List(7, 3, 9, 2)

sum(a)

def isort(xs: List[Int]): List[Int] = {
  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }
  def iter(origin: List[Int], res: List[Int]): List[Int] = origin match {
    case Nil => res
    case p :: ps => iter(ps, insert(p, res))
  }
  iter(xs, Nil)
}

isort(a)














