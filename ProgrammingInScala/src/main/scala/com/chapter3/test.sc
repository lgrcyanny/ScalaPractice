val arr = Array(1, 2, 3)
val list1 = List(1, 2, 3)
val list2 = List(4, 5, 6)
list1 ::: list2
val sets = scala.collection.mutable.Set(1, 2, 3)
sets += 4

implicit def stringToInt(s: String) = s.toInt

implicit val s: Int = "122"

def pp(implicit j:Int, a:Int) = println(a,j)

pp

