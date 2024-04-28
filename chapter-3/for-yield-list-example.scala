@main def m(args: String*) =
  val adjectives = List("One", "Two", "Red", "Blue")
  val nouns = for adj <- adjectives yield
    adj + " Fish"
  println(s"nouns: $nouns")
