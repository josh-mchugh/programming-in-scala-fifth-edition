@main def m(arg: String*) =
  val greetStrings = Array("Hello", ", ", "World!")
  for i <- 0 to 2 do
   print(greetStrings(i))
