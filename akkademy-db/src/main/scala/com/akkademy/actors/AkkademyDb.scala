package com.akkademy.actors

import akka.actor.Actor
import akka.event.Logging
import com.akkademy.messages.SetRequest

import scala.collection.mutable.HashMap

/**
  * Created by sirkleber on 25/09/16.
  */
class AkkademyDb extends Actor {
  val map = new HashMap[String, Any]()
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case SetRequest(key, value) => {
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
    }
    case o => log.info("received unknown message: {}", o)
  }
}
