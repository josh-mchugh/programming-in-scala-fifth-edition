@main def m(args: String*) =
  println("String Example")

  val str = "hello"
  println(s"str.reverse: ${str.reverse}")
  println(s"str.map(_.toUpper): ${str.map(_.toUpper)}")
  println(s"str.drop(3): ${str.drop(3)}")
  println(s"str.slice(1, 4): ${str.slice(1, 4)}")
  val s: Seq[Char] = str
  println(s"$s")

