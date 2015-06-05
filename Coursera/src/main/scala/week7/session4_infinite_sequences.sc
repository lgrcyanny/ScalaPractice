def from(n: Int): Stream[Int] = n #:: from(n + 1)

val nats = from(0)
nats map (_ * 4)
nats(2)

// Sieve Eratosthenes generate prime numbers
def sieve(s: Stream[Int]): Stream[Int] =
  s.head #:: sieve(s.tail filter (_ % s.head != 0))

sieve(from(2)) take 10 toList



def sqrt(x: Double): Double = {
  def isGoodEnough(y: Double, x: Double): Boolean =
    Math.abs(y * y - x) < x * 1e-9

  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2

  def iter(guess: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else iter(improve(guess, x))
  iter(1.0)
}

def sqrtStream(x: Double): Double = {
  def improve(guess: Double): Double =
    (guess + x / guess) / 2
  def isGoodEnough(guess: Double): Boolean =
    Math.abs(guess * guess - x) < x * 1e-9
  lazy val guesses: Stream[Double] =
    1 #:: (guesses map improve)
  guesses filter (isGoodEnough(_)) apply 0
}

sqrtStream(4)