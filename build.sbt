name := """playing-autocomplete"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(jdbc, cache, ws)

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "play2-reactivemongo" % "0.12-RC2",
  "org.webjars" %% "webjars-play" % "2.5.0",
  "org.webjars" % "jquery" % "3.1.0",
  "org.webjars" % "bootswatch-united" % "3.3.5+4",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

