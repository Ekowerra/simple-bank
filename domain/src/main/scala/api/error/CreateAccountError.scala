package fr.fpe.school
package api.error

import io.circe.Codec
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveConfiguredCodec

sealed trait CreateAccountError

object CreateAccountError {
  final case class NameTooLongError(name: String) extends CreateAccountError
  final case object EmptyNameError                extends CreateAccountError

  implicit val config: Configuration                          = Configuration.default
  implicit val configuredJsonCodec: Codec[CreateAccountError] = deriveConfiguredCodec
}
