package day2

import scala.collection.mutable.ListBuffer
import scala.io.Source

//noinspection TypeAnnotation
object day2 extends App {
  def string2(word1: String, word2: String, char1: Char, char2: Char): String = {
    var returnWord = word1 ++ word2
    returnWord = returnWord.replace(char1, char2)
    returnWord
  }

  //  println(string2("ha","llo",'a','e'))
  def operators(num1: Int, num2: Int, plus: Boolean) = {
    if (num1 == num2 == 0) 0
    else if (num1 == 0) num2
    else if (num2 == 0) num1
    else {
      if (plus) num1 + num2 else num1 * num2
    }
  }

  //  println(operators(5, 0, false))

  def iteration(word: String, num: Int) = {
    for (i <- 1 to num) {
      println(word)
    }
  }

  //  iteration("hello",3)

  def iteration2(letter: String, num: Int) = {
    for (i <- 1 to num) {
      for (j <- 1 to num) {
        print(letter)
      }
      print("\n")
    }
  }

  //  iteration2

  def fizzBuzz(word1: String, word2: String, num: Int) = {
    for (i <- 1 to num) {
      var str = new StringBuilder
      if (i % 3 == 0) str.append(word1)
      if (i % 5 == 0) str.append(word2)
      if (str.isEmpty) str = new StringBuilder(i.toString)
      println(str)
    }
  }

  //  fizzBuzz("fizz","buzz",20)

  @scala.annotation.tailrec
  def iterationRecursion(word: String, num: Int): Int = {
    if (num != 0) {
      println(word)
      iterationRecursion(word, num - 1)
    } else 0
  }

  //  iterationRecursion("Hello", 5)

  @scala.annotation.tailrec
  def iteration2Recursion(word: String, init: Int, num: Int): Int = {
    if (num != 0) {
      println(word * init)
      iteration2Recursion(word, init, num - 1)
    } else 0
  }

  //  iteration2Recursion("H", 5,5)

  @scala.annotation.tailrec
  def fizzBuzzRecursion(word1: String, word2: String, target: Int, num: Int): Int = {
    if (num <= target) {
      var str = new StringBuilder
      if (num % 3 == 0) str.append(word1)
      if (num % 5 == 0) str.append(word2)
      if (str.isEmpty) str = new StringBuilder(num.toString)
      println(str)
      fizzBuzzRecursion(word1, word2, target, num + 1)
    } else 0
  }

  //  fizzBuzzRecursion("fizz", "buzz", 20, 1)

  def operatorsMatch(num1: Int, num2: Int, plus: Boolean) = (num1, num2, plus) match {
    case (0, x, _) => x
    case (x, 0, _) => x
    case (x, y, true) => x + y
    case (x, y, false) => x * y
    case _ => "Error!"
  }

  //  println(operatorsMatch(5,10,plus = false))

  def patternMatch2(pair: Any): Unit = pair match {
    case Nil =>
    case a :: as =>
      patternMatch2(as)
      print(s" $a")
    case Array() =>
    case a: Array[Int] =>
      patternMatch2(a.tail)
      print(s" ${a.head}")
    case (x, y) => println(s"$y $x")
    case _ => "default"
  }

  //  patternMatch2(Array(5,10,15,20))

  def brokenKeyboards(full: Boolean) = {
    val amountOfBrokenKeyboards = scala.io.StdIn.readLine("Amount of broken keyboards> ").toInt
    val keyboards = new Array[String](amountOfBrokenKeyboards)
    for (i <- 0 until amountOfBrokenKeyboards) {
      keyboards(i) = scala.io.StdIn.readLine(s"What keys can you use for keyboard ${i + 1}> ")
    }
    val filename = "enable1.txt"

    for (keyboard <- keyboards) {
      var allWords = ListBuffer[String]()
      for (line <- Source.fromFile(filename).getLines) {
        if (!full) {
          if (line.toSet.subsetOf(keyboard.toSet)) allWords += line
          else if (keyboard.toSet == line.toSet) allWords += line
        }
      }
      if (allWords.nonEmpty) println(allWords.maxBy(_.length))
    }
  }
//  brokenKeyboards(true)

  def getRandomWord(): String = {
    val fileName = "hangmanWords.txt"
    val words = Source.fromFile(fileName).getLines().toArray
    words(scala.util.Random.nextInt(words.length))
  }

  def getUserValidCharInput(used:List[Char]): Char = {
    var found = false;
    var letter: Char = 'a'

    while (!found) {
      print("Currently used letters: ")
      used.foreach(el => print(s"$el "))
      print("\n")
      val input = scala.io.StdIn.readLine("please input a character to check> ")
      if (input.length > 1) {
        println("Not a valid input")
      } else {
        val inputChar = input.head
        if (inputChar.isLetter) {
          if (!used.contains(inputChar.toLower)) {
            letter = inputChar.toLower
            found = true
          } else println("already guessed!")
        } else println("Not a valid input")
      }
    }
    letter
  }

  def playHangman()= {
    val word = getRandomWord()
    var playing = true
    var used = ListBuffer[Char]();

    while (playing) {
      val letterGuess = getUserValidCharInput(used.toList)
      used += letterGuess
    }
  }

  playHangman()



}



