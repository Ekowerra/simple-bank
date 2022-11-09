package fr.fpe.school
package api

import api.error.CreateAccountError
import model.Account

import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AccountAPISpec extends AnyWordSpec with Matchers with OptionValues {

  "AccountApi.createAccount" should {
    "return a Left[CreateAccountError] if name is too long or empty" in {
      val myApi = new AccountAPI()

      myApi.createAccount("a" * 16) shouldBe Left(CreateAccountError.NameTooLongError("a" * 16))
      myApi.createAccount("") shouldBe Left(CreateAccountError.EmptyNameError)
      myApi.createAccount("  ") shouldBe Left(CreateAccountError.EmptyNameError)
      myApi.createAccount("Obiwan") shouldBe Right(Account("Obiwan"))
    }
  }
}
