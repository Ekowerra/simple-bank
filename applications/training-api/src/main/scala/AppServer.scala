package fr.fpe.school

import api.AccountAPI
import config.{Config, Database}
import h2.repository.H2AccountRepository
import routes.BankRoutes

import cats.effect.{ExitCode, IO, IOApp}
import doobie.util.transactor.Transactor
import fs2.Stream
import org.http4s.blaze.server.BlazeServerBuilder
import org.http4s.implicits._
import cats.effect.unsafe.implicits.global

object AppServer extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    (for {
      config <- Stream.resource(Config.load())
      transactor <- Stream.resource(Database.transactor(config.database))
      _          <- Stream.eval(Database.initialize(transactor))
      exitCode <- BlazeServerBuilder[IO]
        .bindHttp(config.server.port, config.server.host)
        .withHttpApp(buildBankRoutes(transactor).orNotFound)
        .serve
    } yield exitCode).compile.lastOrError

  private def buildBankRoutes(transactor: Transactor[IO]) = {

    val accountRepository = new H2AccountRepository(transactor)
    val accountAPI        = new AccountAPI(accountRepository)

    val bankRoutes = new BankRoutes(accountAPI)

    bankRoutes.routes

  }
}
