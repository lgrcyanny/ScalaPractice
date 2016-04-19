package com.chapter15

/**
 * Created by lgrcyanny on 16/4/1.
 */
object PatternMatchingExample {
  sealed abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class Unop(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  def simplifyOp(expr: Expr): Expr = expr match {
    case Unop("-", Unop("-", e)) => simplifyOp(e)
    case BinOp("+", e, Number(0)) => simplifyOp(e)
    case BinOp("*", e, Number(1)) => simplifyOp(e)
    case Unop(op, e) => Unop(op, simplifyOp(e))
    case BinOp(op, left, right) => BinOp(op, simplifyOp(left), simplifyOp(right))
    case _ => expr
  }

  class ExprFormatter {
    private val opGroups = Array(
      Set("|", "||"),
      Set("&", "&&"),
      Set("^"),
      Set("==", "!="),
      Set("<", "<=", ">", ">="),
      Set("+", "-"),
      Set("*", "%")
    )
    private val precedence = {
      val assocs = for {
        i ← 0 until opGroups.length
        op ← opGroups(i)
      } yield op -> i
      assocs.toMap
    }

    private val unaryPrecedence = opGroups.length
    // for division
    private val fractionPrecence = -1;
  }

  def simplifyAdd(e: Expr): Expr = e match {
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case _ => e
  }

  def testMatchingConstant() = {
    import math.{E, Pi}
    val pi = Pi
    E match {
      case v@`pi` => println("strange pi = " + v)
      case _ => println("OK")
    }
  }

  def testSequencePattern() = {
    val l = List(1, 2, 3)
    l match {
      case List(1, _*) => println("match")
      case _ => println("not match")
    }
  }

  def main(args: Array[String]) {
    val v = Var("X")
    val n1 = Number(5)
    val n2 = Number(0)
    val res = BinOp("+", n1, n2)
    println(simplifyOp(res))

    println(simplifyAdd(BinOp("+", n1, n1)))
  }
}
