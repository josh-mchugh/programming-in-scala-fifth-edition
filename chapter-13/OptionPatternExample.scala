@main def m(args: String*) =
  println("Option Patterns")
  optionPattern("France")
  optionPattern("North Pole")

def optionPattern(country: String) =
  val captials = Map("France" -> "Paris", "Japan" -> "Tokyo")
  captials.get(country) match
    case Some(s) => println(s"captial: $s")
    case None => println("Where?")
