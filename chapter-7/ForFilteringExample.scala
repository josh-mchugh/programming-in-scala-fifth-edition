@main def m(args: String*) =
  val filesHere = (new java.io.File(".")).listFiles
  for file <- filesHere
      if file.isFile
      if file.getName.endsWith(".scala")
  do println(file)
