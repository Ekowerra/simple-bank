package fr.fpe.school
package api

import model.Account

final class AccountAPI() {

  def createAccount(name: String): Either[String, Account] = {
    for {
      _ <- Either.cond(name.length.<(15), name, "name length must be > 15")
      _ <- Either.cond(!name.isBlank, name, "name cannot be blank")
    } yield {Account(name)}
  }
}
