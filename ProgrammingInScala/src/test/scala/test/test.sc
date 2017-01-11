
"a.b.c.d".split("\\.").toList


def process(name: String) = "your name is " + name

val f = process _
val g = process(_)
g("hello")
g("hello")