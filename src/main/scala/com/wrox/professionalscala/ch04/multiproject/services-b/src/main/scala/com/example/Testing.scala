package com.example

import java.util.concurrent.ScheduledExecutorService

import com.example.domain.DomainTypes._
import com.example.util.{Database, CustomCodecs}
import io.circe._
import io.circe.syntax._
import io.getquill._
import org.http4s.dsl._
import org.http4s.server._

import scala.util.{Failure, Success}

class Testing(ec: ScheduledExecutorService) extends CustomCodecs{
  import scala.concurrent.ExecutionContext.Implicits.global
  implicit def _ec = ec

  def test(): Unit = {
    val q = quote {
      for {
        p <- query[Person]
      } yield p
    }

    val users = Database.db.run(q)
    users onComplete {
      case Success(a) =>
        println(a)

      case Failure(_) =>
        println("all the failz")
    }
  }

  implicit val TestDecoder =
    for {
      message <- Decoder[String]
      x <- Decoder[Int]
    } yield Test(message, x)


  implicit val TestEncoder: Encoder[Test] = Encoder.instance{ a =>
    Json.obj(
      "message" -> Json.string(a.message),
      "x" -> Json.int(a.x)
    )
  }
  val testRoutes = HttpService {
    case GET -> Root / "hello" / id =>
      println(test())
      val json2 = Test(s"hello $id", id.toInt).asJson.noSpaces
      Ok(json2)

    case GET -> Root / "user" / "add" / name / age =>
      Ok("you've been added")
  }
}

