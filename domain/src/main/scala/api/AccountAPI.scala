package fr.fpe.school
package api

import model.Account

final class AccountAPI() {

  def createAccount(name: String): Option[Account] =
    Some(Account(name)).filter(_.name.length <= 15)
}
