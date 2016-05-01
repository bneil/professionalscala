name := "integrationTests"

organization := "com.professionalscala"

version := "0.0.1"

scalaVersion := "2.11.7"

enablePlugins(GatlingPlugin)

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "2.35.0" % "test",
  "org.http4s" %% "http4s-dsl" % "0.12.1",
  "org.http4s" %% "http4s-blaze-server" % "0.12.1",
  "org.mockito" % "mockito-all" % "1.10.19",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.1.7" % "test",
  "io.gatling"            % "gatling-test-framework"    % "2.1.7" % "test"
)

initialCommands := "import com.professionalscala._"

