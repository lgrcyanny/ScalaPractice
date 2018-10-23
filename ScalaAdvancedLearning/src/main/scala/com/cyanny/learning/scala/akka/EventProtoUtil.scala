package com.cyanny.learning.scala.akka

import com.cyanny.learning.akka.EventMessage.{AbnormalState, Event}

object EventProtoUtil {
  def testMerge(): Unit = {
    val eventMsg = Event.newBuilder()
    val state1 = AbnormalState.newBuilder()
    state1.setS1("state1")
    eventMsg.setState(state1)
    println(s"EventState: ${eventMsg.toString}")

    val state2 = AbnormalState.newBuilder()
    state2.setS1("state2.1")
    state2.setS2("state2")
    val mergedState = state1.mergeFrom(state2.build())
    eventMsg.setState(mergedState)
    println(s"EventState: ${eventMsg.toString}")
  }

  def main(args: Array[String]): Unit = {
    testMerge()
  }
}
