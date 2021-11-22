package fr.fpe.school
package api

import fr.fpe.school.model.Account
import org.scalatest.OptionValues
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AccountAPISpec extends AnyWordSpec with Matchers with OptionValues {

  "AccountApi.createAccount" should {
    "return the name" in {
      val myApi = new AccountAPI()
      myApi.createAccount("Obiwan") shouldBe Some(Account("Obiwan"))
    }
    "return none" in {
      val myApi = new AccountAPI()
      myApi.createAccount("çoikçiujyhtgrfyuiooiuytg") shouldBe None
    }
  }
}
