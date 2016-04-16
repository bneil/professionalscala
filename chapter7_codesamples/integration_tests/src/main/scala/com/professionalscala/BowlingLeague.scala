package com.professionalscala

import scala.concurrent.Future

trait BowlingLeague {
  val leagueName: String
  val leagueRules: LeagueRules

  def addTeamToLeague(team: Team): Future[Boolean]
  def removeTeamFromLeague(team: Team): Future[Boolean]

  def teamStandings() : Future[Standings]
}

case class LeagueRules(
  maxTeams: Int,
  leagueType: LeagueType
)
case class Team(name: String, players: Seq[Player])
case class Player(fname: String, lname: String, avg: Int)
case class Standings(currentStandings: Map[Int, Team])

sealed trait LeagueType
case object CashPrize extends LeagueType
case object Seniors extends LeagueType
case object HighSchool extends LeagueType
case object ForFun extends LeagueType
