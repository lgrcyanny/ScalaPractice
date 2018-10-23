package com.cyanny.learning.scala.akka

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import com.cyanny.learning.scala.akka.SimpleActor.{HelloActor, HelloMessage}
import org.scalatest.{BeforeAndAfterAll, FunSpecLike, FunSuite, FunSuiteLike}

class AkkaSuite extends TestKit(ActorSystem("ActorSuite"))
  with FunSuiteLike with ImplicitSender with BeforeAndAfterAll {

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  test("test hello actor") {
    val actor = system.actorOf(Props[HelloActor], "hello-actor")
    val content = "hello"
    actor ! HelloMessage(content)
    expectMsg(content)
  }

}
