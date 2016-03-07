import week4._

object List {
  def apply[T](): List[T] = new Nil[T]
  def apply[T](x: T): List[T]= new Cons[T](x, new Nil[T])
  def apply[T](x: T, y: T, z: T): List[T] =
    new Cons[T](x, new Cons[T](y, new Cons[T](z, new Nil[T])))
}

List(1, 2, 3)

val f = new Function[Int, Int] {
  def apply(v1: Int): Int = v1 * v1
}
f.apply(2)



