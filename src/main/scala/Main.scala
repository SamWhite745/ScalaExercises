object Main extends App {
<<<<<<< HEAD
  def addSmallMultiplyBig(a:Int, b:Int, c:Int) : Int = {
    val nums = List(a,b,c).sorted
    (nums(0) + nums(1)) * nums(2)
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
=======

  println("Hello World!")

>>>>>>> Added hello world
}
