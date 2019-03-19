package com.cyanny.learning.scala.akka

import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.{Executors, TimeUnit}

import akka.actor.{Actor, ActorSystem, Props}
import akka.util.Timeout

import scala.concurrent.{ExecutionContext, Future}

object SimpleActor {
  implicit val executors = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(10))
  implicit val timeout = Timeout.apply(100000, TimeUnit.MILLISECONDS)
  val messageCounter = new AtomicLong(0L)

  case class HelloMessage(content: String)
  class HelloActor extends Actor {
    override def receive = {
      case HelloMessage(content) => {
        println(s"receive $content from ${sender().path}")
        messageCounter.getAndIncrement()
      }
      case _ =>
        println("unknown message")
    }
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("HelloAkkaSystem")
    val actor = system.actorOf(Props[HelloActor], "helloActor")

    val actorSelection = system.actorSelection("helloActor")
    println(actorSelection.anchorPath.toString)
    actorSelection ! HelloMessage("hi")

  }

}
