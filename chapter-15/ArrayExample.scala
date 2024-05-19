@main def m(args: String*) =
  val fiveInts = new Array[Int](5)
  println(s"fiveInts: ${fiveInts.mkString}")

  val fiveToOne = Array(5, 4, 3, 2, 1)
  println(s"fiveToOne: ${fiveToOne.mkString}")

  fiveInts(0) = fiveToOne(4)
  println(s"fiveInts modified: ${fiveInts.mkString}")
