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
//  def iter(origin: List[Int], res: List[Int]): List[Int] = origin match {
//    case Nil => res
//    case p :: ps => iter(ps, insert(p, res))
//  }
//  iter(xs, Nil)
  xs match {
    case Nil => List()
    case x :: xs1 => insert(x, isort(xs1))
  }
}

isort(a)

import scala.math.Ordering
def isort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  def insert(xs: List[T], n: T): List[T] = xs match {
    case Nil => List(n)
    case x :: xs1 => {
      if (ord.lt(n, x))
        n :: insert(xs1, x)
      else
        x :: insert(xs1, n)
    }
  }
//  def iter(xs: List[T], acc: List[T]): List[T] = xs match {
//    case Nil => acc
//    case x :: xs1 => iter(xs1, insert(acc, x))
//  }
//  iter(xs, Nil)
  xs match {
    case Nil => List()
    case x :: xs1 => insert(isort(xs1), x)
  }
}

val list = List(6, 7, 9, 11, 0, 1, -9, 10)
isort(list)












