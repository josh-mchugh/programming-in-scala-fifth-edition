@main def m(args: String*) =
  // print files in current directory
  val filesHere = (new java.io.File(".")).listFiles
  for file <- filesHere do
    println(file)

  // Range type with for
  for i <- 1 to 4 do
    println(s"Range Iteration: $i")

  // Range type without upper bound in for
  for i <- 1 until 4 do
    println(s"Until Iteration: $i")
