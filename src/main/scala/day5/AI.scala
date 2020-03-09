package day5

import scala.collection.mutable.ListBuffer

class AI (var rock:Int = 0, var paper:Int = 0, var scissors:Int = 0, var lizard:Int = 0, var spock:Int = 0){

  def getSmartChoice() = {
    var options = ListBuffer[HandThrow.Value]()
    for (i <- 0 to rock+1) options += HandThrow.ROCK
    for (i <- 0 to paper+1) options += HandThrow.PAPER
    for (i <- 0 to scissors+1) options += HandThrow.SCISSORS
    for (i <- 0 to lizard+1) options += HandThrow.LIZARD
    for (i <- 0 to spock+1) options += HandThrow.SPOCK

    options(scala.util.Random.nextInt(options.length))
  }

  def addChoice(handThrow: HandThrow.Value): Unit = handThrow match {
    case HandThrow.ROCK => rock+=1
    case HandThrow.PAPER => paper+=1
    case HandThrow.SCISSORS => scissors+=1
    case HandThrow.LIZARD => lizard+=1
    case HandThrow.SPOCK => spock+=1
  }
}
