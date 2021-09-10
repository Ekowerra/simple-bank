import sbt._

object Dependencies {

  private val circeVersion               = "0.14.1"
  private val doobieVersion              = "0.13.4"
  private val tapirVersion               = "0.18.3"
  private val slf4jApiVersion            = "1.7.30"
  private val log4catsVersion            = "1.1.1"
  private val logbackVersion             = "1.2.3"
  private val h2Version                  = "1.4.200"
  private val flywayVersion              = "7.5.2"
  private val pureConfigVersion          = "0.12.3"
  private val scalaTestVersion           = "3.2.9"
  private val scalaTestScalaCheckVersion = "3.2.9.0"

  lazy val circe = Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-generic-extras",
    "io.circe" %% "circe-parser",
    "io.circe" %% "circe-literal"
  ).map(_ % circeVersion)

  lazy val log4CatsCore = "io.chrisdavenport" %% "log4cats-core" % log4catsVersion

  lazy val log = Seq(
    "ch.qos.logback"     % "logback-classic" % logbackVersion,
    "ch.qos.logback"     % "logback-core"    % logbackVersion,
    "io.chrisdavenport" %% "log4cats-slf4j"  % log4catsVersion,
    "org.slf4j"          % "slf4j-api"       % slf4jApiVersion
  )

  lazy val doobie = Seq(
    "org.tpolecat" %% "doobie-core",
    "org.tpolecat" %% "doobie-hikari",
    "org.tpolecat" %% "doobie-h2"
  ).map(_ % doobieVersion)

  lazy val tapir = Seq(
    "com.softwaremill.sttp.tapir" %% "tapir-core",
    "com.softwaremill.sttp.tapir" %% "tapir-cats",
    "com.softwaremill.sttp.tapir" %% "tapir-json-circe",
    "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs",
    "com.softwaremill.sttp.tapir" %% "tapir-openapi-circe-yaml",
    "com.softwaremill.sttp.tapir" %% "tapir-http4s-server",
    "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-http4s"
  ).map(_ % tapirVersion)

  lazy val h2 = "com.h2database" % "h2" % h2Version

  lazy val flyway = "org.flywaydb" % "flyway-core" % flywayVersion

  lazy val pureConfig = Seq(
    "com.github.pureconfig" %% "pureconfig",
    "com.github.pureconfig" %% "pureconfig-cats-effect"
  ).map(_ % pureConfigVersion)

  lazy val scalaTest = Seq(
    "org.scalatest"     %% "scalatest"       % scalaTestVersion,
    "org.scalatestplus" %% "scalacheck-1-15" % scalaTestScalaCheckVersion
  )

}
