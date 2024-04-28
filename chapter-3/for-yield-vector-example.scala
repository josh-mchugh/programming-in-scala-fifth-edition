@main def m(args: String*) =
  val ques = Vector("Who", "What", "When", "Where", "Why")
  val usingForYield = for q <- ques yield
    q.toLowerCase + "?"
  println(s"usingForYield: ${usingForYield}")
