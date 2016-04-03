package com.chapter15

/**
 * Created by lgrcyanny on 16/4/1.
 */
object PatternMatchingExample {
  abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class Unop(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  def simplifyOp(expr: Expr): Expr = expr match {
    case e: Var => e
    case e: Number => e
    case Unop("-", Unop("-", e)) => simplifyOp(e)
    case BinOp("+", e, Number(0)) => simplifyOp(e)
    case BinOp("*", e, Number(1)) => simplifyOp(e)
  }

  def main(args: Array[String]) {
    val v = Var("X")
    val n1 = Number(5)
    val n2 = Number(0)
    val res = BinOp("+", n1, n2)
    println(simplifyOp(res))
  }
}
