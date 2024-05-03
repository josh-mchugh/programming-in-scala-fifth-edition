import java.io.FileReader

@main def m(args: String*) =
  val file = new FileReader("ForExample.scala")
  try
    println(file.read())
  finally
    file.close()
