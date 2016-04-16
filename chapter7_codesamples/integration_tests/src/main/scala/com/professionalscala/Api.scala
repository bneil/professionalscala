package com.professionalscala

import org.http4s.HttpService
import org.http4s.dsl._
import org.http4s.server.blaze.BlazeBuilder

object Api extends App{
  val service = HttpService {
    case GET -> Root / "testRoute" =>
      Ok("This is a test route")
  }
    BlazeBuilder.bindHttp(8080)
    .mountService(service, "/")
    .run
    .awaitShutdown()
}
