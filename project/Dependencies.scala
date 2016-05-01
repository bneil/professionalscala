import sbt._

object Dependencies {
  // Versions
  lazy val akkaVersion = "2.3.8"
  lazy val http4sVersion = "0.11.2"

  // Libraries
  val akkaActor   = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % akkaVersion
  val specs2core  = "org.specs2" %% "specs2-core" % "2.4.14"
  val blazeServer = "org.http4s" %% "http4s-blaze-server" % http4sVersion
  val http4sDSL   = "org.http4s" %% "http4s-dsl" % http4sVersion
  val http4sCirce = "org.http4s" %% "http4s-circe" % http4sVersion
  val psql        = "postgresql"   %  "postgresql"  % "9.1-901.jdbc4"
  val quill       = "io.getquill"  %% "quill-async" % "0.2.1"

  // Projects
  val http4s = Seq(
    blazeServer, http4sDSL, http4sCirce
  )

  val db = Seq(
    psql, quill
  )
  val backendDeps =
    Seq(akkaActor, specs2core % Test) ++ http4s ++ db
}