package week7

/**
 * Created by lgrcyanny on 15/6/5.
 */
class Pouring(capacity: Vector[Int]) {
  // States
  type State = Vector[Int]
  val initialState = capacity map (_ => 0)
  // Moves
  trait Move {
    def change(state: State): State
  }
  // glass is the index of in the State Vector
  case class Empty(glass: Int) extends Move {
    def change(state: State): State = state updated (glass, 0)
  }
  case class Fill(glass: Int) extends Move {
    def change(state: State): State = state updated (glass, capacity(glass))
  }
  case class Pour(from: Int, to: Int) extends Move {
    def change(state: State): State = {
      val amount = state(from) min (capacity(to) - state(to))
      state updated (from, state(from) - amount) updated (to, state(to) + amount)
    }
  }
  // Glasses represent by index starting from 0
  val glasses = 0 until capacity.length
  val moves = (for (glass <- glasses) yield Empty(glass)) ++
    (for (glass <- glasses) yield Fill(glass)) ++
    (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))
  // Paths, the latest Move is the head of the List
  class Path(history: List[Move], val endState: State) {
    // there is no need to calculate the endstate every time, record the last endState
    //    def endState: State = (history foldRight(initialState))(_ change _)
    //    private def trackState(xs: List[Move]): State = xs match {
    //      case Nil => initialState
    //      case move :: xs1 => move change trackState(xs1)
    //    }
    def extend(move: Move) = new Path(move :: history, move change endState)
    override def toString = (history.reverse mkString " ") + "->" + endState
  }

  val initialPath = new Path(Nil, initialState)

  // generate all possible paths from initial Path
  // There is no need to visit old state, so record the explored states
  def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] =
    if (paths.isEmpty) Stream.empty
    else {
      val more = for {
        path <- paths
        next <- moves map path.extend
        if !(explored contains(next.endState))
      } yield next
      paths #:: from(more, explored ++ more.map(_.endState))
    }

  val pathSets = from(Set(initialPath), Set(initialState))

  def solution(target: Int): Stream[Path] = for {
    pathSet <- pathSets
    path <- pathSet
    if path.endState.contains(target)
  } yield path
}
