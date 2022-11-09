package fr.fpe.school
package database

import database.error.AccountRepositoryError
import model.Account

import cats.effect.IO

trait AccountRepository {
  def insert(name: String): IO[Either[AccountRepositoryError, Account]]
}
