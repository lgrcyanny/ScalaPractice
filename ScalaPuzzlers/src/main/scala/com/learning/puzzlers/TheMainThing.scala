package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/12/12.
  */
object TheMainThing {

  class AirportDay {
    def tryCheckBag(weight: Int): String = "It's not a full flight, Your bag is OK."
  }

  class StartOfVocation extends AirportDay {
    override def tryCheckBag(weight: Int): String = {
      if (weight > 25) {
        "Your bag is too heavy"
      } else {
        "Your bag is OK"
      }
    }
  }

  def goToCheckIn(bagWeight: Int)(implicit ad: AirportDay) {
    println(s"The agent says: ${ad tryCheckBag bagWeight}")
  }

  object AirportSim {
    def main(args: Array[String]): Unit = {
      implicit val quietTuesday = new AirportDay
      goToCheckIn(26)
      implicit val busyMonday = new StartOfVocation
      goToCheckIn(26)
    }
  }

  object AirportSim2 extends App{
    implicit val quietTuesday = new AirportDay
    goToCheckIn(26)
    implicit val busyMonday = new StartOfVocation
    goToCheckIn(26)
  }

  def main(args: Array[String]): Unit = {
    AirportSim main Array()
//    AirportSim2 main Array() // Throw NullPointerException
  }

}
