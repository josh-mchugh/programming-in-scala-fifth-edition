@main def m(args: String*) =
  def hasUpperCase(s: String) = s.exists(_.isUpper)
  println(s"hasUpperCase(\"Robert Frost\"): ${hasUpperCase("Robert Frost")}")
  println(s"hasUpperCase(\"e e cummings\"): ${hasUpperCase("e e cummings")}")
