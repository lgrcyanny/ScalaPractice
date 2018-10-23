package com.cyanny.learning.scala.akka

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.ask
import com.cyanny.learning.akka.EventMessage

object ActorWithProto {

  class EventServiceActor extends Actor {
    override def receive: Receive = {
      case e: EventMessage.Event =>
        println(s"got event message: ${e.toString}, from ${sender().path.toString}")
        sender() ! e
      case _ => println("unknown event")
    }
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("EventService")
    val actor = system.actorOf(Props[EventServiceActor], "event-handler")
    println(s"actor path: ${actor.path.toSerializationFormat}")
    val eventBuilder = EventMessage.Event.newBuilder()
    eventBuilder.setEventId(1)
    eventBuilder.setEventInfo("event one")
    val event = eventBuilder.build()
    actor ! event
    val selectedActor = system.actorSelection("user/event-handler")
    selectedActor ! event

//    val anotherEventBuilder = EventMessage.Event.newBuilder()
//    anotherEventBuilder.setEventId(2)
//    anotherEventBuilder.setEventInfo("2")
//
//    val mergedEvent = anotherEventBuilder.mergeFrom(eventBuilder.build())
//    println(mergedEvent.build().toString)
  }

}
