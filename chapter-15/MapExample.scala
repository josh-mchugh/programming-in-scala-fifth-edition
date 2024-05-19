import scala.collection.mutable

@main def m(args: String*) =
  val map = mutable.Map.empty[String, Int]
  map("hello") = 1
  map("there") = 2
  println(s"map: $map")
  println(s"map(\"hello\"): ${map("hello")}")

  def countWords(text: String) =
    val counts = mutable.Map.empty[String, Int]
    for rawWord <- text.split("[ ,!.]+") do
      val word = rawWord.toLowerCase
      val oldCount =
        if counts.contains(word) then counts(word)
        else 0
      counts += (word -> (oldCount + 1))
    counts
  println(s"countWords: ${countWords("See Spot run! Run, Spot. Run!")}")








