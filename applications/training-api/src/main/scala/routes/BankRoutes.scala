package fr.fpe.school
package routes

import routes.input.CreateAccountInput

import cats.effect.{Concurrent, ContextShift, IO, Timer}
import cats.syntax.semigroupk._
import org.http4s.HttpRoutes
import sttp.model.StatusCode.Created
import sttp.tapir.Tapir
import sttp.tapir.docs.openapi.OpenAPIDocsInterpreter
import sttp.tapir.json.circe.TapirJsonCirce
import sttp.tapir.openapi.circe.yaml._
import sttp.tapir.server.http4s.Http4sServerInterpreter
import sttp.tapir.swagger.http4s.SwaggerHttp4s

final class BankRoutes(account: AccountAPI)(implicit
    concurrent: Concurrent[IO],
    cs: ContextShift[IO],
    timer: Timer[IO]
) extends Tapir
    with TapirJsonCirce {

  private val createAccount = endpoint
    .in("accounts")
    .post
    .in(jsonBody[CreateAccountInput])
    .out(statusCode(Created) and jsonBody[String])
    .description("create an account and return it")
    .serverLogic[IO](input => IO.pure(account.createAccount(input.name)).map(Right(_)))

  private val endpoints = List(createAccount)

  private val swaggerRoute =
    new SwaggerHttp4s(
      OpenAPIDocsInterpreter().serverEndpointsToOpenAPI[IO](endpoints, "Simple Bank", "0.1").toYaml,
      List("swagger")
    ).routes

  val routes: HttpRoutes[IO] = Http4sServerInterpreter().toRoutes(endpoints) <+> swaggerRoute
}
