@main def m(args: String*) =
  println("List Map Example")

  val map = collection.immutable.ListMap(1 -> "one", 2 -> "two")
  println(s"map: $map")
  println(s"map(2): ${map(2)}")
