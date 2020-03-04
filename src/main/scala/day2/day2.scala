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

  def getRandomWord(difficulty:Int): String = {
    val fileName = "enable1.txt"
    val words = Source.fromFile(fileName).getLines().toArray
    var validWord = false
    var word = ""
    while (!validWord) {
      word = words(scala.util.Random.nextInt(words.length))
      if (difficulty == 1 && word.length <= 5) validWord =true
      else if (difficulty == 2 && (word.length >= 5 && word.length <=8)) validWord = true
      else if (difficulty == 3 && word.length >= 8) validWord = true
    }
    word
  }

  def getUserValidCharInput(used:List[Char]): Char = {
    var found = false;
    var letter: Char = 'a'

    while (!found) {
      print("Currently used letters: ")
      used.foreach(el => print(s"$el "))
      print("\n")
      val input = scala.io.StdIn.readLine("please input a character to check> ")
      if (input.length != 1) {
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

  def printGuessingWord(word:String): Unit = {
    for (letter <-0  until word.length-1) {
      print(s"${word.charAt(letter)} ")
    }
    print(s"${word.last}\n")
  }

  def getLocations(word:String, char:Char) = {
    var locations = ListBuffer[Int]()
    for (i <- 0 until word.length) {
      if (word.charAt(i) == char) locations += i
    }
    locations
  }

  def printHangman(fouls:Int):Unit = fouls match{
    case 11 => Source.fromFile("Hangmen/11.txt").getLines.foreach(println)
    case 10 => Source.fromFile("Hangmen/10.txt").getLines.foreach(println)
    case 9 => Source.fromFile("Hangmen/9.txt").getLines.foreach(println)
    case 8 => Source.fromFile("Hangmen/8.txt").getLines.foreach(println)
    case 7 => Source.fromFile("Hangmen/7.txt").getLines.foreach(println)
    case 6 => Source.fromFile("Hangmen/6.txt").getLines.foreach(println)
    case 5 => Source.fromFile("Hangmen/5.txt").getLines.foreach(println)
    case 4 => Source.fromFile("Hangmen/4.txt").getLines.foreach(println)
    case 3 => Source.fromFile("Hangmen/3.txt").getLines.foreach(println)
    case 2 => Source.fromFile("Hangmen/2.txt").getLines.foreach(println)
    case 1 => Source.fromFile("Hangmen/1.txt").getLines.foreach(println)
    case 0 => Source.fromFile("Hangmen/0.txt").getLines.foreach(println)
  }

  def getDifficulty() : Int = {
    var validInput = false
    var difficulty = 0
    while (!validInput) {
      println("1 - Easy - between 1 and 5 (inclusive)")
      println("2 - Medium - between 5 and 8 (inclusive)")
      println("3 - Hard - more than 8")
      val difficultyInput = scala.io.StdIn.readLine("What difficulty would you like to play on?> ")
      if (difficultyInput == "1" || difficultyInput == "2" || difficultyInput == "3") {
        difficulty = difficultyInput.toInt
        validInput = true
      } else println("Not valid difficulty")
    }
    difficulty
  }

  def playHangman()= {
    println("Welcome to hangman!")
    val difficulty = getDifficulty()
    val word = getRandomWord(difficulty)
    val wordSet = word.toSet
    var playing = true
    var used = ListBuffer[Char]();
    var fouls = 0
    var outputWord = ""
    for (i <- 0 until word.length) {
      outputWord += "_"
    }

    while (playing) {
      Console.flush()
      printGuessingWord(outputWord)
      val letterGuess = getUserValidCharInput(used.toList)
      used += letterGuess

      if (word.contains(letterGuess)) {
        println("Good guess!")
        val locations = getLocations(word, letterGuess)
        for (location <- locations) {
          val outputCharArray = outputWord.toCharArray
          outputCharArray(location) = letterGuess
          outputWord = outputCharArray.mkString("")
        }
        if (outputWord.toSet == wordSet) {
          println("Congratulations, you win!")
          playing = false
        }
      } else {
        println("Foul!")
        fouls+=1
      }
      printHangman(fouls)
      if (fouls == 11) {
        println("Oh dear! you lost!")
        println(s"The word was: $word")
        println("Better luck next time!")
        playing = false
      } else {
        println(s"You have fouled $fouls times")
      }
    }
  }

  playHangman()



}



