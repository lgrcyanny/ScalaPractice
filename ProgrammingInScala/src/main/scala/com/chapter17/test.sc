
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

val arr = new Array[Int](10)
val buf = new ListBuffer[Int]()
buf += 1

val abuf = new ArrayBuffer[Int]()

val words = "foo. bar sss, sks kww".split("[\\s.,!*]+")
val wordSet = mutable.Set[String]()
for (word <- words) wordSet += word
wordSet.size

val map = Map(1 -> "a", 2 -> "b", 3 -> "c")

val sorted = mutable.TreeSet(1, 9, 7, 8, 8, 1)

var people = Set("Nancy", "Jane")

people += "ksk"

var stuff = Set(32)

val colors = List("a", "b", "c")
val treeSet = mutable.TreeSet() ++ colors
treeSet.toList

val muta = mutable.Map("1" -> 1, "2" -> 2)
val immu = Map.empty ++ muta

