@main def m(args: String*) =
  println("Red Black Trees Example")

  val set = collection.immutable.TreeSet.empty[Int]
  println(s"set + 1 + 3 + 3: ${set + 1 + 3 + 3}")
