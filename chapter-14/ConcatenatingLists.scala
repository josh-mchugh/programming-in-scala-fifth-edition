@main def m(args: String*) =
  println(s"${List(1, 2) ::: List(3, 4 ,5)}")
  println(s"${List() ::: List(1, 2, 3)}")
  println(s"${List(1, 2, 3) ::: List(4)}")
