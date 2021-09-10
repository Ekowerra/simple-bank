package fr.fpe.school
package routes.input

import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec
import sttp.tapir.Schema

final case class CreateAccountInput(name: String)

object CreateAccountInput {
  implicit val codec: Codec[CreateAccountInput]   = deriveCodec
  implicit val schema: Schema[CreateAccountInput] = Schema.derived
}
