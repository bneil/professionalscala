name := "unitTest"

organization := "com.example"

version := "0.0.1"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq("org.scalactic" %% "scalactic" % "2.2.6", "org.scalatest" %% "scalatest" % "2.2.6" % "test")

initialCommands := "import com.example.unittest._"

