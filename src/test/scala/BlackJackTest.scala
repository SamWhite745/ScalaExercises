import org.scalatest.FlatSpec
import day4.day4.blackJack

class BlackJackTest extends FlatSpec{
  "blackjack 15 17" should "return 17" in {
    assertResult(blackJack(15,17)){17}
  }
  "blackjack 17 22" should "return 17" in {
    assertResult(blackJack(17,22)){17}
  }
  "blackjack 22 17" should "return 17" in {
    assertResult(blackJack(22,17)){17}
  }
  "blackjack 22 24" should "return 0" in {
    assertResult(blackJack(22,24)){0}
  }
  "blackjack 0 18" should "return 18" in {
    assertResult(blackJack(0,18)){18}
  }
  "blackjack 18 0" should "return 18" in {
    assertResult(blackJack(18,0)){18}
  }



}
