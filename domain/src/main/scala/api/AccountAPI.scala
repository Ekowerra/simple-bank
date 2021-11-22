package fr.fpe.school
package api

import model.Account

final class AccountAPI() {

  def createAccount(name: String): Either[String, Account] = {
    for {
      _ <- Either.cond((name.length < 15), left = "Name to long", right = ())
      _ <- Either.cond((name.trim.nonEmpty), left = "Name is blank", right = ())
    } yield(Account(name))
  }
}