package fr.fpe.school
package h2

import cats.data.NonEmptyList
import doobie.enumerated.JdbcType
import doobie.util.meta.Meta

import java.time.OffsetDateTime

package object implicits {
  implicit val dateTimeType: Meta[OffsetDateTime] = Meta.Advanced.one(
    JdbcType.TimestampWithTimezone,
    NonEmptyList.one("TIMESTAMP WITH TIME ZONE"),
    (rs, col) => rs.getObject(col, classOf[OffsetDateTime]),
    (ps, col, value) => ps.setObject(col, value),
    (rs, col, value) => rs.updateObject(col, value)
  )
}
