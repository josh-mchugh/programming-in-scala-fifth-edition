@main def m(args: String*) =
  println(if (!args.isEmpty) args(0) else "default.txt")
