import week4._

object List {
  def apply[T](): List[T] = new Nil[T]
  def apply[T](x: T): List[T]= new Cons[T](x, new Nil[T])
  def apply[T](x: T, y: T, z: T): List[T] =
    new Cons[T](x, new Cons[T](y, new Cons[T](z, new Nil[T])))
}

List.apply(1, 2, 3)




