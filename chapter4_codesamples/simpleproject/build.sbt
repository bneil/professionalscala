lazy val buildSettings = Seq(
  organization := "com.example",
  version := {
    val minorV = Option(System.getenv().get("currentMinorRelese")).getOrElse("0").toInt
    s"1.0.${minorV}"
  },
  scalaVersion := "2.11.7"
)

wartremoverErrors ++= Warts.unsafe

val http4sVersion = "0.11.2"
lazy val commonSettings = Seq(
  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
    ),
  libraryDependencies ++= Seq(
    "org.http4s"   %% "http4s-blaze-server" % http4sVersion,
    "org.http4s"   %% "http4s-dsl"          % http4sVersion,
    "org.http4s"   %% "http4s-circe"        % http4sVersion
  )
)

val getUname = TaskKey[String]("getUname", "gets the local machines uname")
lazy val root =
  (project in file("."))
    .settings(buildSettings)
     .settings(
       name := "Factorial",
       getUname := {
        Process("uname -a")!!
       },
       description := s"${name.value} using ${scalaVersion.value}"
     )
