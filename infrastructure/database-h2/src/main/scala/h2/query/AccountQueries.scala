package fr.fpe.school
package h2.query

import doobie.implicits._
import doobie.util.fragment
import doobie.h2.implicits._
import h2.implicits._
import model.Account

import java.util.UUID

object AccountQueries {
  val tableName: fragment.Fragment = doobie.Fragment.const("ACCOUNT")

  private val columns = doobie.Fragment.const("id, name, creation_date, status")

  def insert(name: String): doobie.Update0 = sql"""INSERT INTO $tableName (name) VALUES ($name)""".update

  def find(id: UUID): doobie.Query0[Account] =
    sql"""SELECT $columns FROM $tableName WHERE id=$id""".query[Account]

  def findAll(): doobie.Query0[Account] = sql"""SELECT $columns from $tableName""".query[Account]
}
