package com.cyanny.learning.scala.akka

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}

object AkkaHierarchyDemo {
  class PrintMyActorRefActor extends Actor {
    override def receive: Receive = {
      case "printit" =>
        val secondRef = context.actorOf(Props.empty, "second-actor")
        println(s"second-actor: ${secondRef.toString()}")
        println(s"Thread is: ${Thread.currentThread().getName}")
    }
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("testing")
    val actor = system.actorOf(Props[PrintMyActorRefActor], "parent-actor")
    actor ! "printit"

    val children: ActorSelection = system.actorSelection("*second-actor*")
    children
  }
}
