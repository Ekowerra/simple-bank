package fr.fpe.school
package api

import model.Account

final class AccountAPI() {

  def createAccount(name: String): Account = Account(name)
}
