package fr.fpe.school
package database.error

import io.circe.Codec
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveConfiguredCodec

sealed trait AccountRepositoryError

object AccountRepositoryError {
  final case class UniqueKeyAlreadyUsedError(key: String) extends AccountRepositoryError

  implicit val config: Configuration                              = Configuration.default
  implicit val configuredJsonCodec: Codec[AccountRepositoryError] = deriveConfiguredCodec
}
