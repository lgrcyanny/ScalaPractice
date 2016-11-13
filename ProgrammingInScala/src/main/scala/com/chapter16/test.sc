val a :: b :: rest = List(1, 2)

val l = List(1, 2, 3, 4, 5, 6, 7)
l.sliding(2).toList

l.find(_ > 10)

l.forall(_ > 5)

(0 /: l) (_ + _)

(List[Int]() /: l){ (list: List[Int], x: Int) =>
  x :: list
}

val original = List(7, 9, 10, 1)
original.sortWith((x, y) => x.toString.length < y.toString.length)


val r = List(1, 2, 34)
l ::: r


val s = List.range(1, 6)
val t = List.tabulate(5)(n => n * n)

val t1 = (List(1, 2), List(3, 4, 5)).zipped.foreach((x1, x2) => println(x1 + ":" + x2))


//(t :\ List()) (_ ::: _)
