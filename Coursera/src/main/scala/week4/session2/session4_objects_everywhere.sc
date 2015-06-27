import week4.session2._
object session4_objects_everywhere {
  _true && _false
  _true < _false
  _true == _true
  val a = Zero
  val b = new Succ(a)
  val c = new Succ(b)
  val d = new Succ(c)
  b + c + d
  // b - c
  a + b
  c - b
  d - b
  b - a
}




