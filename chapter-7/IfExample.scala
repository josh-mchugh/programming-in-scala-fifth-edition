@main def m(args: String*) =
  val filename =
    if !args.isEmpty then args(0)
    else "default.txt"
  println(filename)

