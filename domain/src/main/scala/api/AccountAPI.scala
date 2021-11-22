package fr.fpe.school
package api

import model.Account

import scala.runtime.Null$

final class AccountAPI() {

  def createAccount(name: String): Option[Account] = Option.unless(name.length > 15)(Account(name));
}
