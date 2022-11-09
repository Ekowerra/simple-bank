package fr.fpe.school
package api

import api.error.CreateAccountError
import database.AccountRepository
import model.Account

import cats.effect.IO
import cats.syntax.traverse._
import cats.syntax.either._

final class AccountAPI(accountRepository: AccountRepository) {
  def createAccount(name: String): IO[Either[CreateAccountError, Account]] =
    validateName(name).flatTraverse(
      accountRepository.insert(_).map(_.leftMap[CreateAccountError](CreateAccountError.InvalidDatabaseRequestError))
    )

  private def validateName(name: String): Either[CreateAccountError, String] = {
    val trimmedName = name.trim
    for {
      _ <- Either.cond(trimmedName.nonEmpty, (), CreateAccountError.EmptyNameError)
      _ <- Either.cond(trimmedName.length <= 15, (), CreateAccountError.NameTooLongError(trimmedName))
    } yield trimmedName
  }
}
