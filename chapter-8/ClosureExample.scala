@main def m(args: String*) =
  // more is the free variable
  var more = 1
  // closure has it's bound 'x' variable and free variable 'more '
  // addMore is a function literal that is 'open term' since it has a free variable
  // At runtime will be required that a binding for its free variable be captured
  // Scala's closures capture variables themselves, not the value which the variable refers to. This way of the var more changes, it will be reflected in the closures output.
  val addMore = (x: Int) => x + more
  println(s"add more closure: ${addMore(10)}")

  val someNumbers = List(-11, -10, -5, 0, 5, 10)
  var sum = 0
  someNumbers.foreach(sum += _)
  println(s"Sum of some numbers: $sum")

  def makeIncreaser(more: Int) = (x: Int) => x + more
  val increase1 = makeIncreaser(1)
  val increase9999 = makeIncreaser(9999)
  println(s"Increase '1': ${increase1(10)}")
  println(s"Increase '9999: ${increase9999(10)}")
