@main def m(arg: String*) =
  val greetStrings = new Array[String](3)
  greetStrings(0) = "Hello"
  greetStrings(1) = ", "
  greetStrings(2) = "World!"

  for i <- 0 to 2 do
   print(greetStrings(i))
