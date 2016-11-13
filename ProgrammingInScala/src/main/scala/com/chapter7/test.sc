var filename = "base";
if (filename.length > 0) {
  filename = "another"
}
filename

def gcdLoop(x: Int, y: Int): Int = {
  var a = x;
  var b = y;
  while (b != 0) {
    val t = a % b
    a = b
    b = t
  }
  a
}

gcdLoop(26, 12)

var s = "s"

(s = "a") == ()

val n: Long = (Math.pow(2.0, 64) - 1)toLong

def f(): Int = {
  try {
    return 1
  } finally {
    return 2
  }
}

def search(args: Array[String], i: Int, patten: String): Int = {
  if (i >= args.length) -1
  else if (args(i).matches(patten)) i
  else search(args, i + 1, patten)
}

search(Array("Scala", "ScalaGroud", "Hello"), 0, "Scala\\w+")

//import scala.util.control.Breaks._
//break

val a = 1
{
  val a = 2
  println(a)
}




