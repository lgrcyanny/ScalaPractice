package com.cyanny.learning.scala.akka

import java.util.concurrent.Executors

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}

import scala.concurrent.ExecutionContext

object WebClient {

  implicit val executors = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(10))
  implicit val actorSystem = ActorSystem("web-client-system")

  def process(): Unit = {
    val responseFuture = Http().singleRequest(HttpRequest(uri = "http://www.baidu.com"))
    responseFuture.onComplete {
      case scala.util.Success(value) =>
        println(value)

      case scala.util.Failure(exception) =>
        println("failure")
    }
  }

  def main(args: Array[String]): Unit = {
    println(HttpResponse(200))
  }

}
