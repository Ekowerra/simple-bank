package fr.fpe.school
package api

import api.error.CreateAccountError
import database.AccountRepository
import model.Account

import cats.Id
import org.mockito.scalatest.IdiomaticMockito
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.time.OffsetDateTime
import java.util.UUID

class AccountAPISpec extends AnyWordSpec with Matchers with OptionValues with IdiomaticMockito {

  "AccountApi.createAccount" should {
    "return a Left[CreateAccountError] if name is too long or empty" in {
      val accountRepository: AccountRepository = mock[AccountRepository]
      val myApi                                = new AccountAPI(accountRepository)

      // We use a mock to simulate the behavior of the function createAccount
      val fakeId                     = UUID.randomUUID()
      val now                        = OffsetDateTime.now()
      def buildAccount(name: String) = Account(fakeId, name, now)
      accountRepository.insert(*) answers buildAccount _

      myApi.createAccount("a" * 16) shouldBe Left(CreateAccountError.NameTooLongError("a" * 16))
      myApi.createAccount("") shouldBe Left(CreateAccountError.EmptyNameError)
      myApi.createAccount("  ") shouldBe Left(CreateAccountError.EmptyNameError)
      myApi.createAccount("Obiwan") shouldBe Right(buildAccount("Obiwan"))
      accountRepository.insert(*) was called
    }
  }
}
