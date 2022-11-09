package fr.fpe.school
package api

import model.Account

final class AccountAPI() {

  def createAccount(name: String): Either[String, Account] =
    validateName(name).map(Account(_))

  private def validateName(name: String): Either[String, String] = {
    val trimmedName = name.trim
    for {
      _ <- Either.cond(trimmedName.nonEmpty, (), "name is empty")
      _ <- Either.cond(trimmedName.length <= 15, (), "name is too long")
    } yield trimmedName
  }
}
