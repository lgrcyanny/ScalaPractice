val list = List(89, 72, 94, 69)
val max = list.max
val min = list.min
val mean: Double = list.sum / 4
val value: Double = (94 - mean) / (max - min)

val second: List[Int] => Int = {
  case x :: y :: _ => y
}

second(List(1, 2))

val a = 1000.11612
a.formatted("%.2f")

"123".toList.drop(2).tail

Option(null).isEmpty
