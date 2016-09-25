package org.akkademy.actorTest

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.akkademy.actors.AkkademyDb
import com.akkademy.messages.SetRequest
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

/**
  * Created by sirkleber on 25/09/16.
  */
class AkkademyDbSpec extends FunSpecLike with Matchers with BeforeAndAfterEach {
  implicit val system = ActorSystem()

  describe("akkademyDb"){
    describe("given SetRequest") {
      it("should place key/value into map"){
        val actorRef = TestActorRef(new AkkademyDb)

        actorRef ! SetRequest("name", "Kleber")

        val akkademyDb = actorRef.underlyingActor

        akkademyDb.map.get("name") should equal(Some("Kleber"))
      }
    }
  }

}
