@main def m(args: String*) =
  val who = Some("Who")
  //val who: Option[String] = None
  val word = for word <- who yield
    word.toUpperCase                             
  println(s"word: $word")
