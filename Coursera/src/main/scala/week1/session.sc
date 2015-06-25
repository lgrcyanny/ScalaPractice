object Session {
  println("Welcom")

  def abs(x: Double) = if (x >= 0) x else -x

  def sqrt(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess, x))

    def isGoodEnough(guess:  Double) =
      abs(guess * guess - x) / x < 1e-9

    def improve(guess: Double, x: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  sqrt(4)

  def and(x: Boolean, y: => Boolean) = if (x) y else false

  def or(x: Boolean, y: => Boolean) = if (x) true else y

  def fib(n: Int): Int = {
    def fibIter(i: Int, a: Int, b: Int): Int = {
      if (i == n) a
      else fibIter(i + 1, b, a + b)
    }
    fibIter(0, 0, 1)
  }
  fib(4)
}