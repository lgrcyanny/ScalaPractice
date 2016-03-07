import scala.annotation.tailrec

object session1_tail_recersion {

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  gcd(-2, 6)


  def factorial(n: Int): Int = {
    @tailrec
    def loop(accumulate: Int, n: Int): Int=
      if (n == 0) accumulate
      else loop(accumulate * n, n - 1)
    loop(1, n)
  }

  factorial(5)

  def factorial2(n: Int): Int =
    if (n == 0) 1 else n * factorial2(n - 1)

  factorial2(4)

  val a = "Hello()"
  val b = a.toList


}