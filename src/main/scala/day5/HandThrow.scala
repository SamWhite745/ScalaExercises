package day5

object HandThrow extends Enumeration {
  val ROCK, PAPER, SCISSORS, LIZARD, SPOCK, UNKNOWN = Value
  def withNameWithDefault(name: String): Value =
    values.find(_.toString.toLowerCase == name.toLowerCase()).getOrElse(UNKNOWN)
}
