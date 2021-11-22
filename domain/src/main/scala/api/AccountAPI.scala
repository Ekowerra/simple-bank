package fr.fpe.school
package api

class AccountAPI {
  private var accountName = "name"

  def createAccount(name: String): String = {
    accountName = name
    accountName
  }
}
