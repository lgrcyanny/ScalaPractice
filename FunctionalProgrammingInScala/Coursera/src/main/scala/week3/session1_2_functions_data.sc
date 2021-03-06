object rationals {
  class Rational(x: Int, y: Int) {
    require(y != 0, "Denominator can't be zero")
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    private val g = gcd(x, y)
    val numerator = x / g
    val denominator = y / g

    // Define a constructor
    def this(x: Int) = this(x, 1)

    def add(that: Rational) =
      new Rational(
        numerator * that.denominator + denominator * that.numerator,
        denominator * that.denominator)

    def neg: Rational =
      new Rational(-numerator, denominator)

    def sub(that: Rational) = add(that.neg)

    override def toString() = numerator + "/" + denominator

    def less(that: Rational) = numerator * that.denominator < denominator * that.numerator

    def equal(that: Rational) = numerator * that.denominator == denominator * that.denominator

    def max(that: Rational) = if (this.less(that)) that else this

  }

  val x = new Rational(2, 6)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  x.add(x)
  x.max(y)
  x.sub(y)

  val h = new Rational(3)

}

