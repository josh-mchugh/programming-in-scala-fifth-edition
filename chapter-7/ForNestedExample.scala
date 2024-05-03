@main def m(args: String*) =
  grep(".*gcd.*")

def fileLines(file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toArray

def grep(pattern: String) =
  val filesHere = (new java.io.File(".")).listFiles
  for
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
  do println(s"$file: ${trimmed}")
