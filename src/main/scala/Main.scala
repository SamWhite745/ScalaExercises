object Main extends App {
  def endString(word:String, number:Int):String = {
    var endWord = ""
    for (i <- word.length-number until word.length){
      endWord += word.charAt(i)
    }

    endWord
  }

  println(endString("Hello", 3))
}
