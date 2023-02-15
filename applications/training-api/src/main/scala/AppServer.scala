package fr.fpe.school

import config.Config
import routes.BankRoutes

import cats.effect.{ExitCode, IO, IOApp}
import fr.fpe.school.api.AccountAPI
import fs2.Stream
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.implicits._

object AppServer extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    (for {
      config <- Stream.resource(Config.load())
      exitCode <- BlazeServerBuilder[IO]
        .bindHttp(config.server.port, config.server.host)
        .withHttpApp(buildBankRoutes().orNotFound)
        .serve
    } yield exitCode).compile.lastOrError

  private def buildBankRoutes() = {

    val accountAPI = new AccountAPI()
    val bankRoutes = new BankRoutes(accountAPI)

    bankRoutes.routes

  }
}
