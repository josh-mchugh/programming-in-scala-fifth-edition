@main def m(args: String*) =
  println("ArrayBuffer Example")

  val buf = collection.mutable.ArrayBuffer.empty[Int]
  println(s"buf += 1: ${buf += 1}")
  println(s"buf += 10: ${buf += 10}")
  println(s"buf.toArray: ${buf.toArray}")
