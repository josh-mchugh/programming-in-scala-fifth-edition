@main def m(args: String*): Unit =
  val res = formatArgs(args)
  assert(res == "zero\none\ntwo")
  print(formatArgs(args))

def formatArgs(args: Seq[String]) =
  args.mkString("\n")
