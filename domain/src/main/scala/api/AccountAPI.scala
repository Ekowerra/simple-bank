package fr.fpe.school
package api

import model.Account

class AccountAPI {
  def createAccount(name: String): Either[String, Account] = {
    if (name.length > 15) {
      Left("Name is too long.")
    } else if (name.isEmpty) {
      Left("Name is too short.")
    } else {
      Right(Account(name))
    }
  }
}