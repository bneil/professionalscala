package com.professionalscala

import org.mockito.Mockito._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mock.MockitoSugar
import org.scalatest.{FunSuite, ShouldMatchers}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class BowlingLeagueSpec
  extends FunSuite
    with ShouldMatchers
    with MockitoSugar
    with ScalaFutures {

  val players: Seq[Player] = Seq(
    Player("Charlie", "Brown", 100),
    Player("Linus", "Pelt", 105),
    Player("Lucy", "Pelt", 125),
    Player("Sally", "Brown", 85)
  )
  val testTeam = Team(
    "Pea Shooters",
    players
  )

  test("Adding a team") {
    val bowlingLeague = mock[BowlingLeague]

    when(bowlingLeague.addTeamToLeague(testTeam)).thenReturn(Future(true))

    val addTeam = bowlingLeague.addTeamToLeague(testTeam)

    addTeam.futureValue should equal(true)
  }

  test("Removing a team") {
    val bowlingLeague = mock[BowlingLeague]

    when(bowlingLeague.addTeamToLeague(testTeam)).thenReturn(Future(true))
    when(bowlingLeague.removeTeamFromLeague(testTeam)).thenReturn(Future(true))

    val remTeam = bowlingLeague.removeTeamFromLeague(testTeam)

    remTeam.futureValue should equal(true)
  }
}
