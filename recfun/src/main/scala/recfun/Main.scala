package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def recurCal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else recurCal(c - 1, r - 1) + recurCal(c, r - 1)
    }
    recurCal(c, r)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def recurBalance(count: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) count == 0
      else {
        if (chars.head == '(') recurBalance(count + 1, chars.tail)
          // Make sure meet '(' before ')'
        else if (chars.head == ')') count > 0 && recurBalance(count - 1, chars.tail)
        else recurBalance(count, chars.tail)
      }
    }
    recurBalance(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0)
      0
    else if (coins.isEmpty)
      if (money == 0) 1 else 0
    else
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
