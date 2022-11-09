package fr.fpe.school
package database

import model.Account

import cats.effect.IO

trait AccountRepository {
  def insert(name: String): IO[Account]
}
