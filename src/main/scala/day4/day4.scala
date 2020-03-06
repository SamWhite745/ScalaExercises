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

//  println(s"is 49927398716 a valid credit card number: ${validCreditCard(49927398716L)}")
//  println(s"without check num: 4992739871, with check num: ${addCheckDigit(4992739871L)}")

  def blackJack(card1:Int, card2:Int) = (card1, card2) match{
    case (0, y) if y<=21 => y
    case (x, 0) if x<=21 => x
    case (x,y) if x>21 && y <= 21 => y
    case (x,y) if x<=21 && y > 21 => x
    case (x,y) => if (x > y) x else y
  }


  @scala.annotation.tailrec
  def onlyOne(num:Int, nums: Array[Int], total:Int = 0): Boolean = (num, nums, total) match {
    case (_, Array(), x) => x==1
    case (x, xs, total) => if (x == xs.head) onlyOne(x, xs.tail, total+1) else onlyOne(x, xs.tail, total)
  }

  def uniqueSum(num1: Int, num2: Int, num3: Int): Int =  {
    Array(num1, num2, num3).filter(x => onlyOne(x, Array(num1, num2, num3))).sum
  }

//  println(uniqueSum(5,4,5))
  //  println(blackJack(22,18))
  //  println(uniqueSum(3,3,3))

  def tooHot(temperature:Int, isSummer:Boolean): Boolean = {
    if (isSummer) (temperature >= 60 && temperature <=100)
    else (temperature >=60 && temperature <= 90)
  }



}
