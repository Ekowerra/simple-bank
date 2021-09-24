package fr.fpe.school
package api

import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AccountAPISpec extends AnyWordSpec with Matchers with OptionValues {

  "AccountApi.createAccount" should {
    "return an Account" in {
      val myApi = new AccountAPI()
      myApi.createAccount("Obiwan") shouldBe ???
    }
  }
}
