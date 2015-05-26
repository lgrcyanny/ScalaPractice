import week4._

//def assertAllPos[S <: IntSet](r: S): S

1 == 2

false < true

val a = List(1, 2, 3, 4)
a.map(_ + 2)
a.foreach(println _)
trait PlaceholderExample {
  def process[A](f: A => Unit)
  val set: Set[_ => Unit]
  //set.foreach(process _) // Error
  set.foreach(process(_)) // No Error
}

val list = List()

def op = (x: Int, y: Int) => x + y
list.foldLeft(0)(op)
