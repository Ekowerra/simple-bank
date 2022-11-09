package fr.fpe.school
package routes

import api.AccountAPI
import api.error.CreateAccountError
import model.Account
import routes.input.CreateAccountInput

import cats.effect.{Concurrent, IO}
import io.circe.generic.auto._
import org.http4s.HttpRoutes
import sttp.model.StatusCode.{BadRequest, Created, Forbidden}
import sttp.tapir.Tapir
import sttp.tapir.generic.auto.schemaForCaseClass
import sttp.tapir.json.circe.TapirJsonCirce
import sttp.tapir.server.ServerEndpoint
import sttp.tapir.server.http4s.Http4sServerInterpreter
import sttp.tapir.swagger.bundle.SwaggerInterpreter

final class BankRoutes(accountAPI: AccountAPI)(implicit
    concurrent: Concurrent[IO]
) extends Tapir
    with TapirJsonCirce {

  private val createAccount = endpoint
    .in("accounts")
    .post
    .in(jsonBody[CreateAccountInput])
    .out(statusCode(Created) and jsonBody[Account])
    .errorOut(
      oneOf[CreateAccountError](
        oneOfVariant(BadRequest, jsonBody[CreateAccountError.NameTooLongError]),
        oneOfVariant(BadRequest, jsonBody[CreateAccountError.EmptyNameError.type]),
        oneOfVariant(Forbidden, jsonBody[CreateAccountError.InvalidDatabaseRequestError])
      )
    )
    .description("create an account and return it")
    .serverLogic[IO](input => accountAPI.createAccount(input.name))

  private val apiEndpoints: List[ServerEndpoint[Any, IO]] = List(createAccount)

  private val docEndpoints: List[ServerEndpoint[Any, IO]] = SwaggerInterpreter()
    .fromServerEndpoints[IO](apiEndpoints, "scala-tutorial", "1.0.0")

  val routes: HttpRoutes[IO] = Http4sServerInterpreter[IO]().toRoutes(apiEndpoints ++ docEndpoints)
}
