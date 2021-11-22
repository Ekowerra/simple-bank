package fr.fpe.school
package api

case class Account(name: String)

final class AccountAPI() {
  def createAccount(name: String): Account = {
    Account(name)
  }

}
