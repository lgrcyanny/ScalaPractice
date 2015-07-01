package week6

/**
 * Created by lgrcyanny on 15/7/1.
 */
class Queens {

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else {
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield queens :+ col
      }
    }
    placeQueens(n)
  }

  // List(k) is the col for kth queen
  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val positions = (0 to row) zip queens
    positions.forall {
      case (r, c) => (c != col) && (Math.abs(c - col) != Math.abs(r - row))
    }
  }

}
