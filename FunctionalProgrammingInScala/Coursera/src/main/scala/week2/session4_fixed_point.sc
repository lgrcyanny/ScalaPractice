import Math.abs
object example {
  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def isCloseEnough(x: Double, y: Double) =
      abs((x - y) / x) / x < 1.0e-9

    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }
  fixedPoint(x => 1 + x / 2)(1)


  def sqrt(x: Double) =
    fixedPoint(y => (y + x / y) / 2.0)(1)


  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
  def sqrt2(x: Double) =
    fixedPoint(averageDamp(y => x / y))(1.0)

  sqrt2(2)

  def f = ((x: Int) => ((y: Int) => (x + y)))
  f(1)(2)
}

