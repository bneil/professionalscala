package com.example

import java.util.concurrent.Executors

import org.http4s.server.blaze.BlazeBuilder

object SimpleServer extends App {
  private val pool = Executors.newScheduledThreadPool(3)

  val routes = new Testing(pool).testRoutes

  BlazeBuilder.bindHttp(8080)
    .mountService(routes, "/")
    .run
    .awaitShutdown()
}


