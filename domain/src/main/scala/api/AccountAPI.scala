package fr.fpe.school
package api

import model.Account

sealed trait AccountError
case class EmptyName() extends AccountError
case class TooLongName() extends AccountError

class AccountAPI {
  def createAccount(name: String): Either[AccountError, Account] = {
    if (name.length > 15) {
      Left(TooLongName())
    } else if (name.isEmpty) {
      Left(EmptyName())
    } else {
      Right(Account(name))
    }
  }
}