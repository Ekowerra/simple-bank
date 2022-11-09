package fr.fpe.school
package model

import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec

import java.time.OffsetDateTime
import java.util.UUID

final case class Account(id: UUID, name: String, creationDate: OffsetDateTime)

object Account {
  implicit val codec: Codec[Account] = deriveCodec
}
