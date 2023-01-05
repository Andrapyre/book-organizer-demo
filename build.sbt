ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.4"

lazy val root = (project in file("."))
  .settings(
    name := "book-organizer-demo",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % "test"
  )

