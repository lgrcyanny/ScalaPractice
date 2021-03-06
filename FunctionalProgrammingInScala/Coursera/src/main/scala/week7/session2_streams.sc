def isPrime(n: Int) = 2 until n forall(n % _ != 0)
def nthPrime(from: Int, to: Int, n: Int): Int = {
  if (from >= to) throw new Error("No Prime")
  else if (isPrime(from))
    if (n == 0) from else nthPrime(from + 1, to, n - 1)
  else
    nthPrime(from + 1, to, n)
}
nthPrime(1000, 100000, 1)

((1000 to 10000) filter (isPrime))(1) // Performance not good
// Better to use stream
((1000 to 10000).toStream filter (isPrime))(1)


def streamRange(low: Int, high: Int): Stream[Int] =
  if (low > high) Stream.empty
  else
    Stream.cons(low, streamRange(low + 1, high))

def streamList(low: Int, high: Int): List[Int] =
  if (low > high) Nil
  else
    low :: streamList(low + 1, high)

streamRange(1, 10)
streamList(1, 10)
List().forall((x: Int) => x > 10)
streamRange(1, 10).take(3).toList
1 #:: 2 #:: 3 #:: Stream.empty


case class Person(name: String)
Person("He").name
