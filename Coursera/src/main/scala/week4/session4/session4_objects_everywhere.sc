import week4.session4._

object session4_objects_everywhere {
  _true && _false
  _true < _false
  _true == _true

  val a = Zero
  val b = new Succ(Zero)
  val c = new Succ(new Succ(b))
  val d = new Succ(new Succ(new Succ(b)))
  b + c + d
  // b - c
  a + b
  d - b
}











