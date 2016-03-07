def expr = {
  val x = {print("x"); 1}
  lazy val y = {print("y"); 2}
  def z = {print("z"); 3}
  z + y + x + z + y + x
}
expr


def streamRange(low: Int, high: Int): Stream[Int] = {
  if (low > high) Stream.empty
  else
    Stream.cons(low, streamRange(low + 1, high))
}

def isPrime(n: Int) = (2 until n) forall (n % _ != 0)

streamRange(1000, 10000).filter(isPrime(_)) apply 1
