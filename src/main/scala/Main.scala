object Main extends App {
  def addSmallMultiplyBig(a:Int, b:Int, c:Int) : Int = {
    var nums = List(a,b,c)
    nums = nums.sorted

    (a+b)*c
  }
  def oneBottle(num:Int) = {
    if (num==1) "bottle"
    else "bottles"
  }

  def bottlesOfBeer(bottles : Int): Unit = {
    for (i <- bottles to 1 by -1) {
      println(s"$i ${if (i==1) "bottle" else "bottles"} of beer on the wall")
      println(s"$i ${if (i==1) "bottle" else "bottles"} of beer")
      println(s"Take one down, pass it around")
      println(s"${i - 1} ${if (i-1==1) "bottle" else "bottles"} of beer")
    }
    println("go get more beer!")
  }

  println(addSmallMultiplyBig(3,4,5))
  bottlesOfBeer(99)
}
