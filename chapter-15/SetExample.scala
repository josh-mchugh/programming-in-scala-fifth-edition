import scala.collection.mutable

@main def m(args: String*) =
  val text = "See Spot run. Run, Spot. Run!"
  val wordsArray = text.split("[ !,.]+")
  val words = mutable.Set.empty[String]
  for word <- wordsArray do
    words += word.toLowerCase
  println(s"text: $text")
  println(s"words: $words")
