package fr.fpe.school
package api

import model.Account

import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AccountAPISpec extends AnyWordSpec with Matchers with OptionValues {

  "AccountApi.createAccount" should {
    "return None if name is incorrect" in {
      val myApi = new AccountAPI()

      myApi.createAccount("a" * 16) shouldBe None
      myApi.createAccount("Obiwan") shouldBe Some(Account("Obiwan"))
    }
  }
}
