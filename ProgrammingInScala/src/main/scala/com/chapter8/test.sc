val increase = ((x: Int) => x + 1)
increase(2)

List(-1, 1, 1, 3, 12).filter(_ > 0)

val f = (_: Int) + (_: Int)
f(1, 3)

val numbers = List(-1, 1, 1, 3, 12)
numbers.foreach(println _)
def sum(a: Int, b: Int, c: Int) = a + b + c
val a = sum _
a(1, 2, 3)
val b = sum(1, _: Int, 2)
b(3)
println(numbers.dropWhile(_ > 0))

def makeIncrease(more: Int) = (x: Int) => x + more
val h1 = makeIncrease(1)
val h2 = makeIncrease(100)
h1(1)
h2(1)

def echo(args: String*) = for (arg ← args) println(arg)
echo("1", "21", "as")
echo(Array("a", "b"): _*)
"1" * 8

Array("a", "b") zip Array("c")



