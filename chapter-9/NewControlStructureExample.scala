@main def m(args: String*) =
  def withPrintWriter(file: java.io.File)(op: java.io.PrintWriter => Unit) =
    val writer = new java.io.PrintWriter(file)
    try op(writer)
    finally writer.close()

  val file = new java.io.File("date.txt")
  withPrintWriter(file) { writer =>
    writer.println(new java.util.Date)
  }
