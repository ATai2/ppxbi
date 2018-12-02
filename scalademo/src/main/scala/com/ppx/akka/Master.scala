package com.ppx.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

class Master extends Actor {

  override def preStart(): Unit = {
    println("prepare")
  }

  override def postStop(): Unit = {
    println("stop")
  }

  override def receive: Receive = {
    case "connect" => {
      println("a client connected")
      sender ! "reply"
    }
    case "hello" => {
      println("hello")
    }

  }
}

object Master extends App {

  val host = args(0)
  val port = args(1).toInt

  var configStr =
    s"""
       |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname = "$host"
       |akka.remote.netty.tcp.port = "$port"
     """.stripMargin

  val config = ConfigFactory.parseString(configStr)
  val actorSystem = ActorSystem("MasterSystem",config)
  val master: ActorRef = actorSystem.actorOf(Props(new Master()),"Master")
  master ! "Hello"

//  actorSystem.terminate()

}
