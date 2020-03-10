import org.scalatest.FlatSpec
import day4.day4.uniqueSum

class UniqueSumTest extends FlatSpec{
  "Unique sum (2,2,3)" should "return 3" in {
    assertResult(uniqueSum(2,2,3)){3}
  }
  "Unique sum (2,2,2)" should "return 0" in {
    assertResult(uniqueSum(2,2,2)){0}
  }
  "Unique sum (1,2,3)" should "return 6" in {
    assertResult(uniqueSum(1,2,3)){6}
  }
}
