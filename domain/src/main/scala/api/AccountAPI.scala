package fr.fpe.school
package api

import model.Account

final class AccountAPI() {

  def createAccount(name: String): Option[Account] =
    Some(Account(name.trim)).filter(account => account.name.nonEmpty && account.name.length <= 15)
}
