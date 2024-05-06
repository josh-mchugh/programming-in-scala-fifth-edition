@main def m(ars: String*) =
  val filesEnding = FileMatcher.filesEnding(".scala")
  println(filesEnding.map(_.getName).mkString(", "))

  val filesContaining = FileMatcher.filesContaining("Order")
  println(filesContaining.map(_.getName).mkString(", "))

  val filesRegex = FileMatcher.filesRegex(".*")
  println(filesRegex.map(_.getName).mkString(", "))

object FileMatcher:
  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: String => Boolean) =
    for file <- filesHere if matcher(file.getName)
    yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))
