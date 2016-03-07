val n = 7
val pairs = 1 until n map (
  i => 1 until i map (y => (i, y)))
// Implement flatten
(pairs foldLeft Seq[(Int, Int)]())((x, y) => x ++ y)

val pairs2 = (1 until n map (
  i => 1 until i map (y => (i, y)))).flatten
val pairs3 = 1 until n flatMap (
  i => 1 until i map (y => (i, y)))
def isPrime(n: Int) = (2 until n) forall (x => n % x != 0)
val primePairs = (1 until n flatMap (
  i => 1 until i map (y => (i, y)))) filter
  (pair => isPrime(pair._1 + pair._2))

for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)

def scalaProduct(xs: List[Double], ys: List[Double]): Double =
  (for ((x, y) <- xs zip ys) yield x * y) sum
val xs = List(1.0, 2.0, 3.0, 4.0, 5.0)
val ys = List(8.1, 9.0, 7.5, 1.2, 1.2)
scalaProduct(xs, ys)

for {
  j <- 1 to 3
  i <- List(1, 2, 3, 4)
} yield i


