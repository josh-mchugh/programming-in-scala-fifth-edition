@main def m(args: String*) =
  val oneTwo = List(1, 2)
  val threeFour = List(3, 4)
  val oneTwoThreeFour = oneTwo ::: threeFour

  println(oneTwoThreeFour)
