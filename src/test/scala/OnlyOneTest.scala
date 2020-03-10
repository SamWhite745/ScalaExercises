import org.scalatest.FlatSpec
import day4.day4.onlyOne

class OnlyOneTest extends FlatSpec{
  "Only one of (1, (6, 4, 1, 2, 2, 5))" should "return true" in {
    assert(onlyOne(1, Array(6, 4, 1, 2, 2, 5)))
  }
  "Only one of (2, (6, 4, 1, 2, 2, 5))" should "return false" in {
    assert(!onlyOne(2, Array(6, 4, 1, 2, 2, 5)))
  }
  "Only one of (1, ())" should "return false" in {
    assert(!onlyOne(1, Array()))
  }
  "Only one of (1, (6, 4, 3, 2, 2, 5))" should "return false" in {
    assert(!onlyOne(1, Array(6, 4, 3, 2, 2, 5)))
  }
}
