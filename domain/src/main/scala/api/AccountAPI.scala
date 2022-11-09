package fr.fpe.school
package api

import api.error.CreateAccountError
import model.Account

final class AccountAPI() {

  def createAccount(name: String): Either[CreateAccountError, Account] =
    validateName(name).map(Account(_))

  private def validateName(name: String): Either[CreateAccountError, String] = {
    val trimmedName = name.trim
    for {
      _ <- Either.cond(trimmedName.nonEmpty, (), ???)
      _ <- Either.cond(trimmedName.length <= 15, (), ???)
    } yield trimmedName
  }
}
