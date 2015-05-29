trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case Prod(e1, e2) => e1.eval * e2.eval
  }

  def show: String = this match {
    case Number(n) => n.toString
    case Prod(Sum(e1, e2), Sum(e3, e4)) =>  "(" +  e1.show + " + " + e2.show + ")" + " * " + "(" + e3.show + " + " + e4.show + ")"
    case Prod(Sum(e1, e2), e3) => "(" +  e1.show + " + " + e2.show + ")" + " * " + e3.show
    case Prod(e1, Sum(e2, e3)) => e1.show + "*" + "(" +  e2.show + " + " + e3.show + ")"
    case Sum(e1, e2) => e1.show + " + " + e2.show
    case Prod(e1, e2) => e1.show + " * " + e2.show
    case Var(v) => v.toString
  }
}
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Var(v: String) extends Expr

Prod(Sum(Prod(Sum(Number(1), Var("x")), Sum(Number(1), Var("y"))), Number(1)), Var("z")).show











