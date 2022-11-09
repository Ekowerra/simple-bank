package fr.fpe.school
package database

import model.Account

import java.util.UUID

trait AccountRepository {
  def insert(name: String): Account
}
