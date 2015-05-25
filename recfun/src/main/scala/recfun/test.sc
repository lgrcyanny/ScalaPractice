import scala.annotation.tailrec


def pascal(c: Int, r: Int): Int = {
  def recurCal(acc: Int, c: Int, r: Int): Int = {
    if (c <= 0 || c >= r) acc + 1
    else recurCal(acc, c - 1, r - 1) + recurCal(acc, c, r - 1)
  }
  recurCal(0, c, r)
}

def main(args: Array[String]) {
  println("Pascal's Triangle")
  for (row <- 0 to 10) {
    for (i <- 0 to 11 - row)
      print(" ")
    for (col <- 0 to row)
      print(pascal(col, row) + " ")
    println("\n")
  }
}

def balance(chars: List[Char]): Boolean = {
  def recurCal(count: Int, chars: List[Char]): Int= {
    if (chars.isEmpty) count
    else {
      if (chars.head == '(') {
        recurCal(count + 1, chars.tail)
      } else if (chars.head == ')') {
        recurCal(count - 1, chars.tail)
      } else {
        recurCal(count, chars.tail)
      }
    }
  }
  recurCal(0, chars) == 0
}

balance("(if (zero? x) max (/ 1 x))".toList)

balance("))(".toList)

balance("".toList)

def countChange(money: Int, coins: List[Int]): Int = {
  def recurCount(money: Int, coins: List[Int], count: Int): Int = {
    if (money < 0) 0
    else if (coins.isEmpty) {
      if (money == 0) count + 1 else 0
    } else {
      recurCount(money - coins.head, coins, count) + recurCount(money, coins.tail, count)
    }
  }
  recurCount(money, coins, 0)
}

countChange(4, List(1, 2))

countChange(5, List(1))









