import Dependencies._

scalaVersion in Global := "2.11.7"

lazy val buildSettings = Seq(
  organization := "com.wrox.professionalscala",
  description := "the root description.",
  version := "1.0.0",
  scalaVersion := "2.11.7"
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

lazy val core =
  (project in file("core"))
    .settings(buildSettings)

lazy val servicesa =
  (project in file("services-a"))
    .settings(buildSettings)
    .dependsOn(core)
    .aggregate(core)

lazy val servicesb =
  (project in file("services-b"))
    .settings(buildSettings)
    .settings(libraryDependencies ++= backendDeps)
    .dependsOn(core)
    .aggregate(core)
