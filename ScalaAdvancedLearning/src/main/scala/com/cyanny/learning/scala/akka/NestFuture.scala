package com.cyanny.learning.scala.akka

import java.util.concurrent.Executors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern._

import scala.concurrent.{ExecutionContext, Future, Promise}

object NestFuture {

  case class ProcessCmd(msg: String, promise: Promise[ProcessResult])
  case class ProcessResult(res: String)
  class Worker extends Actor {
    override def receive: Receive = {
      case ProcessCmd(msg, promise) =>
        println(s"got cmd: $msg")
        promise.success(ProcessResult("processResult"))

      case _ =>
        println("unknown cmd")
    }
  }

  def process(actor: ActorRef, cmd: String): Future[ProcessResult] = {
    val promise = Promise[ProcessResult]
    val future = promise.future
    actor ! ProcessCmd(cmd, promise)
    future
  }

  def main(args: Array[String]): Unit = {
    implicit val executor = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(10))
    val system = ActorSystem("processor-system")
    val workerActor = system.actorOf(Props[Worker], "worker")
    val task = process(workerActor, "process1")
    task.onSuccess {
      case ProcessResult(res) =>
        println(s"got process result: $res")
    }
  }
}
