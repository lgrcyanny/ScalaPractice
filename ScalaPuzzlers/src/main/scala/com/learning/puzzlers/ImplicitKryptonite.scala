package com.learning.puzzlers

/**
  * Created by lgrcyanny on 17/11/12.
  */
object ImplicitKryptonite {
  import Scanner._
  object Scanner {
    trait Console {def display(item: String)}
    trait AlarmHandler extends (() => Unit)

    def scanItem(item: String)(implicit c: Console) = {
      c.display(item)
    }

    def hitAlarmButton()(implicit ha: AlarmHandler) = {
      ha()
    }
  }

  abstract class OperatingMode {
    implicit val ConsoleRenderer = new Console {
      override def display(item: String) = println(s"Found an $item")
    }
    implicit val DefaultAlarmHandler = new Scanner.AlarmHandler {
      def apply() { println("ALARM! ALARM!") }
    }
  }

  object NormalMode extends OperatingMode

  object TestMode extends OperatingMode {
    override implicit val ConsoleRenderer = new Console {
      override def display(item: String) = println(s"Found a detonator")
    }
    implicit val TestAlarmHandler = new Scanner.AlarmHandler {
      def apply() { println("Test successfully, well done") }
    }
  }

  def main(args: Array[String]): Unit = {
//    import NormalMode._
//    Scanner scanItem "knife"
//    Scanner.hitAlarmButton()

    import TestMode._
    Scanner scanItem "shoe"
    Scanner.hitAlarmButton()
  }
}
