import scala.io.StdIn.readLine

@main def m(args: String*) =
  while
    val line = readLine()
    println(s"Read: $line")
    line != ""
  do ()
