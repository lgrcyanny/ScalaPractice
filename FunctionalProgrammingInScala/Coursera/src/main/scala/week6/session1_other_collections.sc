val v = Vector(1, 2, 4, 5, 6)
1 +: v

val xs = Array(4, 5, 6, 7, 8 ,9)
xs map (_ * 3)

val r = 1 until 10 by 2
r.start
r.end
r.step

val s = "Hello Scala"
s.zip(xs)
List(1, 2, 3).zip(s).unzip
(s map (x => List('.', x))).flatten mkString
s.flatMap(x => List('.', x))

// List all combinations of x and y, where x is 1 to M, y is 1 to N
val M = 10
val N = 20
1 to M flatMap(x => 1 to N map (y => (x, y)))


def scalaProduct(x: Vector[Int], y: Vector[Int]): Int = {
  x zip y map{case (x, y) => x * y} sum
}
val v1 = Vector(1, 2, 3)
val v2 = Vector(4, 5, 6)
scalaProduct(v1, v2)

def isPrime(n: Int): Boolean = 2 until n forall (x => n % x != 0)
isPrime(2)


















