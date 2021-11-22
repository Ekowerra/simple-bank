package fr.fpe.school
package api

import model.Account

class AccountAPI {
  def createAccount(name: String): Account = Account(name)
}