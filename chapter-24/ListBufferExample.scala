@main def m(args: String*) =
  println("ListBuffer Example")

  val buf = collection.mutable.ListBuffer.empty[Int]
  println(s"buf += 1: ${buf += 1}")
  println(s"buf += 10: ${buf += 10}")
  println(s"buf.toList: ${buf.toList}")
