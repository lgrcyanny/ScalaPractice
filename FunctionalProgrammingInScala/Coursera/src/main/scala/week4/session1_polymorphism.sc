import week3.Rational
import week4._
object session1_polymorphism {
  def singleton[T](elem: T): List[T] = new Cons[T](elem, new Nil[T])

  def nth[T](n: Int, xs: List[T]): T = {
    if (n < 0 || xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)
  }
  val list = new Cons(1, new Cons(4, new Cons(5, new Nil)))
  nth(2, list)
}