def isPrime(n: Int) = (2 until n) forall (x => n % x != 0)
val n = 5
for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)

(1 until n).flatMap(i =>
  for (j <- 1 until i if isPrime(i + j)) yield (i, j))
(1 until n).flatMap(i =>
  for (j <- (1 until i).withFilter(j => isPrime(i + j))) yield (i, j))
(1 until n).flatMap(i =>
  (1 until i).withFilter(j => isPrime(i + j)).map(j => (i, j)))
