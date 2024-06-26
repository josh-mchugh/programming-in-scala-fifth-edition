@main def m(args: String*) =
  val result = Padding.padLines("Hello World", 50)
  println(result)

object Padding:
  def padLines(text: String, minWidth: Int): String =
    def padLine(line: String): String =
      if line.length >= minWidth then line
      else line + "!" * (minWidth - line.length)
    val paddedLines =
      for line <- text.linesIterator yield
        padLine(line)
    paddedLines.mkString("\n")
