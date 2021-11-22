package fr.fpe.school
package api

import model.Account

class AccountAPI {
  def createAccount(name: String): Option[Account] = {
    if (name.length > 15) {
      None
    }
    Some(Account(name))
  }
}