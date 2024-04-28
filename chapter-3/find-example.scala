@main def m(args: String*) =
  val ques = Vector("Who", "What", "When", "Where", "Why")
  //val found = ques.find(q => q.startsWith("W"))
  val found = ques.find(q => q.startsWith("H"))
  println(s"found: $found")
