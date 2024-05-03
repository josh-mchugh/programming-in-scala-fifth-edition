@main def m(args: String*) =
  val filesHere = (new java.io.File(".")).listFiles
  val scalaFiles =
    for
      file <- filesHere
      if file.getName.endsWith(".scala")
    yield file.getName
  println(scalaFiles.mkString("\n"))
