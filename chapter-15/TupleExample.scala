@main def m(args: String*) =
  def longestWord(words: Array[String]): (String, Int) =
    var word = words(0)
    var idx = 0
    for i <- 1 until words.length do
      if words(i).length > word.length then
        word = words(i)
        idx = i
    (word, idx)

  val longest = longestWord("The quick brown fox".split(" "))
  println(s"longest word: $longest")
  println(s"word: ${longest(0)}, index: ${longest(1)}")
  val (word, idx) = longest
  println(s"word: $word, index: $idx")


