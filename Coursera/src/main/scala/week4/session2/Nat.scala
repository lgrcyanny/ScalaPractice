package week4.session2
import week4.session2._

/**
 * Created by lgrcyanny on 15/5/25.
 * It's an implementation to represents non-negative integers, called natural numbers
 */
abstract class Nat {
  def isZero: Boolean
  // smaller than current value by 1
  def predecessor: Nat
  // bigger than current value by 1
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = _true
  def predecessor: Nat = throw new Error("Zero Predecessor")
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = that.isZero.ifThenElse(this, throw new Error("negative number"))
  override def toString = "0"
}

// n is the current value, the class is the successor of n
class Succ(val n: Nat) extends Nat {
  def isZero: Boolean = _false
  // smaller than current value n by 1
  def predecessor: Nat = n

  def + (that: Nat): Nat = new Succ(n + that)
  def - (that: Nat): Nat = that.isZero.ifThenElse(n, n - that.predecessor)
  override def toString = {
    def iter(acc: Int, x: Nat): Int = {
      // Since originally, ifThenElse is type (t: T, e: T) => T, t and e are call by value, hence,
      // iter(acc + 1, x.predecessor) will be always calculated, so x.predecessor will throw Error when x is zero
      // change ifThenEles to clall by name type: (t: => T, e: => T) => T
      x.isZero.ifThenElse(acc, iter(acc + 1, x.predecessor))
    }
    val number = iter(0, n.successor)
    number + ""
  }
}
