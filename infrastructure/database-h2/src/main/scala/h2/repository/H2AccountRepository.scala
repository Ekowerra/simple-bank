package fr.fpe.school
package h2.repository

import database.AccountRepository
import database.error.AccountRepositoryError
import h2.implicits._
import h2.query.AccountQueries
import model.Account

import cats.effect.IO
import cats.effect.unsafe.IORuntime
import doobie.h2.implicits._
import doobie.implicits._
import doobie.util.transactor.Transactor
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException

import java.time.OffsetDateTime
import java.util.UUID

final class H2AccountRepository(transactor: Transactor[IO])(implicit ioRuntime: IORuntime) extends AccountRepository {
  override def insert(name: String): IO[Either[AccountRepositoryError, Account]] =
    AccountQueries
      .insert(name)
      .withUniqueGeneratedKeys[(UUID, OffsetDateTime)]("id", "creation_date")
      .map { case (id, creationDate) =>
        Right(Account(id, name, creationDate))
      }
      .transact(transactor)
      .handleErrorWith { case _: JdbcSQLIntegrityConstraintViolationException =>
        IO.pure(Left(AccountRepositoryError.UniqueKeyAlreadyUsedError(name)))
      }

}
