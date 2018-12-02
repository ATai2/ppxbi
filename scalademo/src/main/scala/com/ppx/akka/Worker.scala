package com.ppx.akka

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

class Worker(val masterHost: String, val masterPort: Int) extends Actor {

  var master: ActorSelection = _

  //在master启动时会打印下面的那个协议, 可以先用这个做一个标志, 连接哪个master
  //继承actor后会有一个context, 可以通过它来连接
  override def preStart(): Unit = {
    println("worker prepare")
    master = context.actorSelection(s"akka.tcp://MasterSystem@$masterHost:$masterPort/user/Master") //需要有/user, Master要和master那边创建的名字保持一致
    master ! "connect"
  }

  override def receive: Receive = {
    case "reply" => {
      println("a reply form master")
    }
  }
}

object Worker extends App {

  val host = args(0)
  val port = args(1).toInt

  val masterHost = args(2)
  val masterPort = args(3).toInt

  var configStr =
    s"""
       |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname = "$host"
       |akka.remote.netty.tcp.port = "$port"
     """.stripMargin

  val config = ConfigFactory.parseString(configStr)
  val actorSystem = ActorSystem("MasterSystem", config)
  val worker: ActorRef = actorSystem.actorOf(Props(new Worker(masterHost,masterPort)), "Worker")

}
