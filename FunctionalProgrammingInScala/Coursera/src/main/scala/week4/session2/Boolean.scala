package week4.session2

/**
 * Created by lgrcyanny on 15/5/25.
 */
abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean): Boolean = ifThenElse(x, _false)
  def || (x: => Boolean): Boolean = ifThenElse(_true, x)
  def unary_! : Boolean = ifThenElse(_false, _true)
  def == (x:Boolean): Boolean = ifThenElse(x, !x)
  def != (x: Boolean): Boolean = ifThenElse(!x, x)
  def < (x: Boolean): Boolean = ifThenElse(_false, x)
}

object _true extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = t
  override def toString = "true"
}

object _false extends Boolean {
  def ifThenElse[T](t: => T, e: => T): T = e
  override def toString = "false"
}
