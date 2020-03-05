package day4

object day4 extends App {
  def validCreditCard(cardNumber:Long): Boolean = {
    luhn(cardNumber) == 0
  }

  def luhn(cardNumber:Long, double:Boolean = false, total:Long = 0): Long = {
    if (cardNumber > 0) {
      if (double) {
        if (cardNumber%10 * 2 >9) luhn(cardNumber/10, false,total + ((cardNumber%10) * 2) % 10 + 1)
        else luhn(cardNumber/10, double = false, total + cardNumber%10 * 2)
      }
      else luhn(cardNumber/10, double = true, total+(cardNumber%10))
    } else {
      total % 10
    }
  }

  def addCheckDigit(cardNumber:Long):Long = {
    cardNumber*10 + (10 - luhn(cardNumber, true))
  }

  println(s"is 49927398716 a valid credit card number: ${validCreditCard(49927398716L)}")
  println(s"without check num: 4992739871, with check num: ${addCheckDigit(4992739871L)}")

}
