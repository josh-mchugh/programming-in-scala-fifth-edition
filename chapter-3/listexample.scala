@main def m(args: String*) =
  val oneTwo = List(1, 2)
  val threeFour = List(3, 4)
  val oneTwoThreeFour = oneTwo ::: threeFour

  println("Output of List concatenation:")
  println(oneTwoThreeFour)

  val twoThree = List(2, 3)
  val oneTwoThree = 1 :: twoThree

  println("Output of List 'con' prepend operation:")
  println(oneTwoThree)
