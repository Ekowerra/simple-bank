import sbt._

object Dependencies {

  private val circeVersion               = "0.14.3"
  private val tapirVersion               = "1.1.4"
  private val http4sVersion              = "0.23.12"
  private val slf4jApiVersion            = "2.0.3"
  private val log4catsVersion            = "2.5.0"
  private val logbackVersion             = "1.4.4"
  private val pureConfigVersion          = "0.17.1"
  private val scalaTestVersion           = "3.2.14"
  private val scalaTestScalaCheckVersion = "3.2.11.0"

  lazy val circe: Seq[ModuleID] = Seq(
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-generic-extras" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "io.circe" %% "circe-literal" % circeVersion
  )


  lazy val log: Seq[ModuleID] = Seq(
    "ch.qos.logback" % "logback-classic" % logbackVersion,
    "ch.qos.logback" % "logback-core" % logbackVersion,
    "org.typelevel" %% "log4cats-core"    % log4catsVersion,
    "org.typelevel" %% "log4cats-slf4j"  % log4catsVersion,
    "org.slf4j"          % "slf4j-api"       % slf4jApiVersion
  )

  lazy val tapir: Seq[ModuleID] = Seq(
    "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % tapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-cats"  % tapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-json-circe"  % tapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-http4s-server"  % tapirVersion,
    "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-bundle" % tapirVersion,
  )

  lazy val http4s = "org.http4s" %% "http4s-blaze-server" % http4sVersion

  lazy val pureConfig: Seq[ModuleID] = Seq(
    "com.github.pureconfig" %% "pureconfig" % pureConfigVersion,
    "com.github.pureconfig" %% "pureconfig-cats-effect" % pureConfigVersion
  )

  lazy val scalaTest: Seq[ModuleID] = Seq(
    "org.scalatest"     %% "scalatest"       % scalaTestVersion,
    "org.scalatestplus" %% "scalacheck-1-15" % scalaTestScalaCheckVersion
  )

}
