package day2

object day2 extends App {
  def string2(word1: String, word2: String, char1: Char, char2: Char): String = {
    var returnWord = word1 ++ word2
    returnWord = returnWord.replace(char1, char2)
    returnWord
  }

  //  println(string2("ha","llo",'a','e'))
  def operators(num1: Int, num2: Int, plus: Boolean) = {
    if (num1 == num2 == 0) 0
    else if (num1==0) num2
    else if (num2 == 0 )num1
    else {
      if (plus) num1 + num2 else num1 * num2
    }
  }
//  println(operators(5, 0, false))

  def iteration(word:String, num:Int) = {
    for (i <- 1 to num) {
      println(word)
    }
  }
//  iteration("hello",3)

  def iteration2(letter:String, num:Int) = {
    for (i <- 1 to num) {
      for (j <- 1 to num) {
        print(letter)
      }
      print("\n")
    }
  }
//  iteration2

  def fizzBuzz(word1:String, word2:String, num:Int) = {
    for (i <- 1 to num) {
      var str = new StringBuilder
      if (i%3==0) str.append(word1)
      if (i%5==0) str.append(word2)
      if (str.isEmpty) str = new StringBuilder(i.toString)
      println(str)
    }
  }
//  fizzBuzz("fizz","buzz",20)

  def iterationRecursion (word:String, num:Int) : Int = {
    if (num != 0) {
      println(word)
      iterationRecursion(word, num - 1)
    } else 0
  }
//  iterationRecursion("Hello", 5)

  def iteration2Recursion (word:String,init:Int, num:Int) : Int = {
    if (num != 0) {
      println(word*init)
      iteration2Recursion(word, init, num-1)
    } else 0
  }
//  iteration2Recursion("H", 5,5)

  def fizzBuzzRecursion(word1:String, word2:String, target:Int, num:Int) : Int = {
    if (num <= target) {
      var str = new StringBuilder
      if (num%3==0) str.append(word1)
      if (num%5==0) str.append(word2)
      if (str.isEmpty) str = new StringBuilder(num.toString)
      println(str)
      fizzBuzzRecursion(word1, word2, target, num+1)
    } else 0
  }
//  fizzBuzzRecursion("fizz", "buzz", 20, 1)
}



