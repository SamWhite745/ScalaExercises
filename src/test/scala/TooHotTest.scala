import org.scalatest.FlatSpec
import day4.day4.tooHot

class TooHotTest extends FlatSpec{
  "TooHot 99 true" should "return true" in {
    assert(tooHot(99, true))
  }
  "TooHot 110 true" should "return false" in {
    assert(!tooHot(110, true))
  }
  "TooHot 99 false" should "return false" in {
    assert(!tooHot(99, false))
  }
  "TooHot 70 false" should "return true" in {
    assert(tooHot(70, false))
  }
}
