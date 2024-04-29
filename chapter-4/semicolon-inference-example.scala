@main def m(args: String*) =
  val x = 3; println(s"x is $x")
  if x < 2 then
    println("too small")
  else
    println("ok")
