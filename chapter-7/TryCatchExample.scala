import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

@main def m(args: String*) =
  try
    val f = new FileReader("input.txt")
  catch
    case ex: FileNotFoundException => println("Unable to find file.")
    case ex: IOException => println("IO Exception occurred")
