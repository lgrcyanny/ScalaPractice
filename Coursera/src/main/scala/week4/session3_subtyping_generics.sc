import week4.{NonEmpty, Empty, IntSet}
// return an IntSet if all element is positive
// def assertAllPos[S <: IntSet](r: S): S

// Test Array not covariant
val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
//val b: Array[IntSet] = a // Expression type Array[NonEmpty] doesn't comform to type Array[IntSet]
//b(0) = Empty
//val s: NonEmpty = a(0)

