package com.professionalscala.simulation

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class ApiSim extends Simulation {
  val numUsers = 100
  val host = "http://127.0.0.1:8080"

  val httpConf = http.baseURL(host)


  val scn = {
    scenario(s"testing the testResource ( $host )")
      .exec(
        http("testRouteSim")
          .get("/testRoute")
          .check(status.is(200)
          )
      )
  }

  setUp(scn.inject(rampUsers(numUsers) over 20.seconds)).protocols(httpConf)
}
