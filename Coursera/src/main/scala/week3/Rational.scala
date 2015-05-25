package week3

/**
 * Created by lgrcyanny on 15/5/24.
 */
class Rational(x: Int, y: Int) {
  require(y != 0, "Denominator can't be zero")
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numerator = x / g
  def denominator = y / g

  def this(x: Int) = this(x, 1)

  def + (that: Rational) =
    new Rational(
      numerator * that.denominator + denominator * that.numerator,
      denominator * that.denominator)

  def * (that: Rational) =
    new Rational(numerator * that.numerator, denominator * that.denominator)

  def / (that: Rational) =
    this * new Rational(that.denominator, that.numerator)

  def unary_- : Rational =
    new Rational(-numerator, denominator)

  def - (that: Rational) = this + -that

  override def toString() = numerator + "/" + denominator

  def less(that: Rational) = numerator * that.denominator < denominator * that.numerator

  def max(that: Rational) = if (this.less(that)) that else this
}
