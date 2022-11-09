package fr.fpe.school
package api

import model.Account

import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AccountAPISpec extends AnyWordSpec with Matchers with OptionValues {

  "AccountApi.createAccount" should {
    "return a Left[CreateAccountError] if name is too long or empty" in {
      val myApi = new AccountAPI()

      myApi.createAccount("a" * 16) shouldBe Left(???)
      myApi.createAccount("") shouldBe Left(???)
      myApi.createAccount("  ") shouldBe Left(???)
      myApi.createAccount("Obiwan") shouldBe Right(Account("Obiwan"))
    }
  }
}
