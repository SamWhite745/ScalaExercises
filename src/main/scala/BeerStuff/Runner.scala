package BeerStuff

object Runner extends App {
  val stella = Beer("Stella", "781681")
  val guinness = Beer("Guinness", "1879621")
  val corona = Beer("Corona", "4719521")

  guinness.printBeerInfo()


  println(s"Stella is of instance Stella: ${stella.isInstanceOf[Stella]}")
  println(s"Corona is of instance Beer: ${corona.isInstanceOf[Beer]}")
}
