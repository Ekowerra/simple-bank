package fr.fpe.school
package api

import api.error.CreateAccountError
import database.AccountRepository
import model.Account

final class AccountAPI(accountRepository: AccountRepository) {
  def createAccount(name: String): Either[CreateAccountError, Account] =
    validateName(name).map(accountRepository.insert)

  private def validateName(name: String): Either[CreateAccountError, String] = {
    val trimmedName = name.trim
    for {
      _ <- Either.cond(trimmedName.nonEmpty, (), CreateAccountError.EmptyNameError)
      _ <- Either.cond(trimmedName.length <= 15, (), CreateAccountError.NameTooLongError(trimmedName))
    } yield trimmedName
  }
}
