@main def m(args: String*) =
  val x1 = 42
  val x2 = 42
  val x3 = x1

  println(s"x1 == x2: ${x1 == x2}")
  println(s"x1.equals(x2): ${x1.equals(x2)}")
  println(s"x1.## ${x1.##}")
  println(s"x1.hashCode: ${x1.hashCode}")
  println(s"x1.toString: ${x1.toString}")
  println(s"x1 eq x2: ${x1 eq x2}")
  println(s"x1 ne x2: ${x1 ne x2}")
  println(s"x1 eq x2: ${x1 eq x3}")


