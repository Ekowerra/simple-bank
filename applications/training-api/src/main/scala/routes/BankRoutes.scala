package fr.fpe.school
package routes

import routes.input.CreateAccountInput

import cats.effect.{Concurrent, IO}
import org.http4s.HttpRoutes
import sttp.model.StatusCode.Created
import sttp.tapir.Tapir
import sttp.tapir.json.circe.TapirJsonCirce
import sttp.tapir.server.ServerEndpoint
import sttp.tapir.server.http4s.Http4sServerInterpreter
import sttp.tapir.swagger.bundle.SwaggerInterpreter

final class BankRoutes()(implicit
    concurrent: Concurrent[IO]
) extends Tapir
    with TapirJsonCirce {

  private val createAccount = endpoint
    .in("accounts")
    .post
    .in(jsonBody[CreateAccountInput])
    .out(statusCode(Created) and jsonBody[String])
    .description("create an account and return it")
    .serverLogic[IO](input => IO.pure(input.name).map(Right(_)))

  private val apiEndpoints: List[ServerEndpoint[Any, IO]] = List(createAccount)

  private val docEndpoints: List[ServerEndpoint[Any, IO]] = SwaggerInterpreter()
    .fromServerEndpoints[IO](apiEndpoints, "scala-tutorial", "1.0.0")

  val routes: HttpRoutes[IO] = Http4sServerInterpreter[IO]().toRoutes(apiEndpoints ++ docEndpoints)
}
