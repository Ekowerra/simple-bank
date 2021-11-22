package fr.fpe.school
package api

import model.Account

final class AccountAPI() {

  def createAccount(name: String): Option[Account] = {
    if (!Some(name).filter(_.trim.length > 0).isEmpty && name.length <= 15) {
        Some(Account(name))
    } else None
  }
}
