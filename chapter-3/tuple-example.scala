@main def m(args: String*) =
  val pair = (99, "Luftballons")
  val num = pair(0)
  val what = pair(1)
  println(s"$num $what")
