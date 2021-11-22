package fr.fpe.school
package api

import model.Account

final class AccountAPI() {

  def createAccount(name: String): Option[Account] = {
    if (name.length > 15) {
      return None
    }
    Some(Account(name))
  }
}
