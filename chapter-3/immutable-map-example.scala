@main def m(args: String*) =
  val romanNumeral = Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
  )
  val four = romanNumeral(4)
  println(s"Roman Numeral 4: $four")
