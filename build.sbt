name := "professionalscala"

version := "1.0.0"

scalaVersion := "2.11.8"

scalacOptions := Seq(
    "-encoding", "utf8",
    "-deprecation",
    "-unchecked")

lazy val buildSettings = Seq(
  organization := "com.wrox.professionalscala",
  description := "",
  version := "1.0.0",
  scalaVersion := "2.11.8"
)

lazy val ch04MultiProject =
    (project in file("src/main/scala/com/wrox/professionalscala/ch04/multiproject"))
      .settings(buildSettings)

lazy val ch04SimpleProject =
    (project in file("src/main/scala/com/wrox/professionalscala/ch04/simpleproject"))
      .settings(buildSettings)

lazy val ch07IntegrationTests =
    (project in file("src/main/scala/com/wrox/professionalscala/ch07/integration_tests"))
      .settings(buildSettings)

lazy val ch07UnitTests =
    (project in file("src/main/scala/com/wrox/professionalscala/ch07/unit_tests"))
      .settings(buildSettings)
