package fr.fpe.school
package api

import model.Account

final class AccountAPI() {

  def createAccount(name: String): Either[String, Account] = {
    Either.cond[String, Account](name.length < 15 && name.trim.nonEmpty, right = Account(name), left = "Error name")
  }

}
