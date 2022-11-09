ThisBuild / scalaVersion := "2.13.3"

ThisBuild / scalacOptions ++= Seq(
  "-deprecation:false",
  "-Xfatal-warnings",
  "-language:higherKinds",
  "-Ymacro-annotations"
)
ThisBuild / Compile / doc / scalacOptions += "-no-java-comments"
ThisBuild / updateOptions := updateOptions.value.withGigahorse(false)

ThisBuild / name := "simple-bank"

ThisBuild / version := "0.1"

ThisBuild / idePackagePrefix := Some("fr.fpe.school")

lazy val domain = (project in file("domain"))
  .settings(
    libraryDependencies ++= Dependencies.circe,
    libraryDependencies ++= Dependencies.log,
    libraryDependencies ++= Dependencies.scalaTest.map(_ % Test)
  )

lazy val `database-h2` = (project in file("infrastructure/database-h2"))
  .dependsOn(domain)
  .settings(
    libraryDependencies += Dependencies.h2,
    libraryDependencies += Dependencies.flyway,
    libraryDependencies ++= Dependencies.doobie
  )

lazy val `training-api` = (project in file("applications/training-api"))
  .dependsOn(
    domain % "test->test;compile->compile",
    `database-h2`
  )
  .settings(
    libraryDependencies ++= Dependencies.tapir,
    libraryDependencies += Dependencies.http4s,
    libraryDependencies ++= Dependencies.pureConfig,
    name := "training-api"
  )

addCommandAlias("run", "; compile ; project training-api ; runMain fr.fpe.school.AppServer")
