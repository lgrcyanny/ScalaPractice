package com.cyanny.learning.scala.akka

import java.util.concurrent.{Executors, TimeUnit}

import akka.actor.{Actor, ActorSystem, Props}
import akka.util.Timeout

import scala.concurrent.{ExecutionContext, Future}

object SimpleActor {
  implicit val executors = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(10))
  implicit val timeout = Timeout.apply(100000, TimeUnit.MILLISECONDS)

  case class HelloMessage(content: String)
  class HelloActor extends Actor {
    override def receive = {
      case HelloMessage(content) => {
        println(s"receive $content")
        println(s"sender path: ${sender().path}")
        sender ! content
      }
      case _ =>
        println("unknown message")
    }
  }

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("HelloAkkaSystem")
    val actor = system.actorOf(Props[HelloActor], "helloActor-eventHandler")
    println(actor.path.toString)
    actor ! HelloMessage("hello")
    val f: Future[String] = akka.pattern.ask(actor, HelloMessage("hello")).mapTo[String]
    f.onSuccess {
      case str => println(s"got result: $str")
    }
  }

}
