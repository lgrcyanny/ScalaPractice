abstract class Keyed {
  def computeKey(v: Int): Int
}

class MemKey extends Keyed {
  var cached: Option[Int] = None

  def computeKey(v: Int): Int = {
    if (cached.isDefined) cached.get else 0
  }
}

class Time {
  private[this] var m = 0
  private[this] var h = 0

  def minute = m
  def minute_= (x: Int) = {
    require(x >= 0 && x <= 60)
    m = x
  }

  def unary_! = -m
}

val t = new Time
t.minute = 57
!t

