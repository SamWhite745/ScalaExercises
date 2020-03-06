package BeerStuff

class Beer (val beerName: String,val productCode:String) {
  def printBeerInfo() : Unit = {
    println(s"The beer is $beerName and the product code is $productCode")
  }
}

class Guinness(beerName:String, productCode: String) extends Beer(beerName, productCode)
class Stella(beerName:String, productCode: String) extends Beer(beerName, productCode)


object Beer {
  private val uuid = 1
  def apply(beerName: String, productCode: String): Beer = {
    beerName match {
      case "Guinness" => new Guinness(beerName, productCode)
      case "Stella" => new Stella(beerName, productCode)
      case _ => new Beer(beerName, productCode)
    }
  }
}