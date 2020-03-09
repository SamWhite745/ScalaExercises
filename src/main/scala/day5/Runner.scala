package day5

object Runner extends App {

  def fight(handOne: HandThrow.Value, handTwo: HandThrow.Value): Result.Value = handOne match {
    case HandThrow.ROCK => rockFight(handTwo)
    case HandThrow.PAPER => paperFight(handTwo)
    case HandThrow.SCISSORS => scissorsFight(handTwo)
    case HandThrow.LIZARD => lizardFight(handTwo)
    case HandThrow.SPOCK => spockFight(handTwo)
  }

  def rockFight(challenger: HandThrow.Value): Result.Value = challenger match {
    case HandThrow.ROCK => Result.DRAW
    case HandThrow.PAPER => Result.LOSE
    case HandThrow.SCISSORS => Result.WIN
    case HandThrow.LIZARD => Result.WIN
    case HandThrow.SPOCK => Result.LOSE
  }

  def paperFight(challenger: HandThrow.Value): Result.Value = challenger match {
    case HandThrow.ROCK => Result.WIN
    case HandThrow.PAPER => Result.DRAW
    case HandThrow.SCISSORS => Result.LOSE
    case HandThrow.LIZARD => Result.LOSE
    case HandThrow.SPOCK => Result.WIN
  }

  def scissorsFight(challenger: HandThrow.Value): Result.Value = challenger match {
    case HandThrow.ROCK => Result.LOSE
    case HandThrow.PAPER => Result.WIN
    case HandThrow.SCISSORS => Result.DRAW
    case HandThrow.LIZARD => Result.WIN
    case HandThrow.SPOCK => Result.LOSE
  }

  def lizardFight(challenger: HandThrow.Value): Result.Value = challenger match {
    case HandThrow.ROCK => Result.LOSE
    case HandThrow.PAPER => Result.WIN
    case HandThrow.SCISSORS => Result.LOSE
    case HandThrow.LIZARD => Result.DRAW
    case HandThrow.SPOCK => Result.WIN
  }

  def spockFight(challenger: HandThrow.Value): Result.Value = challenger match {
    case HandThrow.ROCK => Result.WIN
    case HandThrow.PAPER => Result.LOSE
    case HandThrow.SCISSORS => Result.WIN
    case HandThrow.LIZARD => Result.LOSE
    case HandThrow.SPOCK => Result.DRAW
  }

  def getResult(winner: HandThrow.Value, loser: HandThrow.Value): String = (winner, loser) match {
    case (HandThrow.ROCK, HandThrow.SCISSORS) => "Rock breaks Scissors"
    case (HandThrow.ROCK, HandThrow.LIZARD) => "Rock crushes Lizard"
    case (HandThrow.PAPER, HandThrow.ROCK) => "Paper covers Rock"
    case (HandThrow.PAPER, HandThrow.SPOCK) => "Paper disproves Spock"
    case (HandThrow.SCISSORS, HandThrow.PAPER) => "Scissors cut Paper"
    case (HandThrow.SCISSORS, HandThrow.LIZARD) => "Scissors decapitates Lizard"
    case (HandThrow.LIZARD, HandThrow.PAPER) => "Lizard eats Paper"
    case (HandThrow.LIZARD, HandThrow.SPOCK) => "Lizard Poisons Spock"
    case (HandThrow.SPOCK, HandThrow.SCISSORS) => "Spock smashes Scissors"
    case (HandThrow.SPOCK, HandThrow.ROCK) => "Spock vaporises Rock"
  }

  def play(handOne: HandThrow.Value, handTwo: HandThrow.Value):Unit = {
    fight(handOne, handTwo) match {
      case Result.WIN => println(getResult(handOne, handTwo))
      case Result.LOSE => println(getResult(handTwo, handOne))
      case _ => println("Draw!")
    }
  }

  @scala.annotation.tailrec
  def getHand(player: String, found: Boolean = false): HandThrow.Value = {
    val hand = HandThrow.withNameWithDefault(scala.io.StdIn.readLine(s"$player - please input a valid selection: "))
    if (hand != HandThrow.UNKNOWN) hand
    else getHand(player)
  }

  def getPlayType(): Int = {
    scala.io.StdIn.readLine("Would you like to play against a human or AI? (1 - Human, 2 - AI, 3 - Quit): ") match {
      case "1" => 1
      case "2" => 2
      case "3" => 3
      case _ =>
        println("not a valid input! try again!")
        0
    }
  }

  def start() = {
    var playing = true
    val ai = new AI()


    do {
      println();
      getPlayType() match {
        case 0 => println("Not a valid choice")
        case 1 =>
          val handOne = getHand("Player 1")
          val handTwo = getHand("Player 2")
          play(handOne, handTwo)
        case 2 =>
          val handOne = getHand("Player 1")
          val handTwo = ai.getSmartChoice()
          println(s"AI chose : ${handTwo.toString}")
          ai.addChoice(handOne)
          play(handOne, handTwo)
        case 3 => playing = false
      }
    } while (playing)
  }

  start()
}
