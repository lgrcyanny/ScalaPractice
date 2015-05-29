trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def number: Int
  def leftOp: Expr
  def rightOp: Expr
  def eval: Int
}

class Number(n: Int) extends Expr {
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def number: Int = n
  def leftOp: Expr = throw new Error("Number.LeftOperator")
  def rightOp: Expr = throw new Error("Number.RightOperator")
  def eval: Int = number
}

class Sum(left: Expr, right: Expr) extends Expr {
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def number: Int = throw new Error("Sum.numberValue")
  def leftOp: Expr = left
  def rightOp: Expr = right
  def eval: Int = left.eval + right.eval
}

new Sum(new Number(1), new Number(2)).eval
