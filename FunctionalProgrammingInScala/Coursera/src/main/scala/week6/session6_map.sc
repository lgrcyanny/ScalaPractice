val words = Map('h'-> 1, 'e' -> 2, 'o' -> 3, 'l' -> 4, 'l' -> 5, 'o' -> 6)
//words('a') // Throw no such element exception
words get 'h'
words ++ Map('h' -> 2, 'e' -> 3)


def showCharacter(c: Char) = words.get(c) match {
  case Some(c) => c
  case None => "Missing character"
}
showCharacter('a')
showCharacter('h')


List("a", "b", "c", "c", "d", "a").groupBy(_.head)
words.groupBy(_._1)
words.map{
  case (x, y) => (y, x)
}
words.toList


// Polynomial, exponents map to coefficients
class Poly(terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  val terms = terms0 withDefaultValue 0.0
  // def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))

  // Use foldLeft is more efficient than concat, becase concat will create new map
  def + (other: Poly) =
    new Poly((terms.foldLeft(other.terms)(addTerm)))

  def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
    val (exp, coeff) = term
    terms + (exp -> (coeff + terms(exp)))
  }

  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coeff) = term
    exp -> (coeff + terms(exp))
//    terms get (exp) match {
//      case Some(coeff1) => exp -> (coeff + coeff1)
//      case None => exp -> coeff // equivalent to (expo, coeff)
//    }
  }

  override def toString =
    (for ((exp, coeff) <- terms.toList.sorted.reverse)
          yield coeff + "x^" + exp) mkString " + "
}

val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
val p2 = new Poly(0 -> 3.0, 3 -> 7.0)

p1.terms(7)

p1 + p2

val countries = Map(("US", "Washington"), ("China", "Beijing"))
countries.groupBy(x => x._1.length)














