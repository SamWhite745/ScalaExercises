import org.scalatest.FlatSpec
import day4.day4.luhn
import day4.day4.validCreditCard
import day4.day4.addCheckDigit

class LuhnTest extends FlatSpec{
  "Luhn 49927398716" should "return 0" in {
    assertResult(luhn(49927398716L)){0}
  }
  "Luhn 4992739871" should "return 9" in {
    assertResult(luhn(4992739871L)){9}
  }

  "Valid credit card 49927398716" should "return true" in {
    assert(validCreditCard(49927398716L))
  }
  "Valid credit card 49927398717" should "return false" in {
    assert(!validCreditCard(49927398717L))
  }

  "add check num to 4992739871" should "return 49927398716" in {
    assertResult(addCheckDigit(4992739871L)){49927398716L}
  }


}
