@main def m(args: String*) =
  println("LazyList Example")

  val str = 1 #:: 2 #:: 3 #:: LazyList.empty
  println(s"str: ${str.toList}")

  def fibFrom(a: Int, b: Int): LazyList[Int] =
    a #:: fibFrom(b, a + b)

  val fibs = fibFrom(1, 1).take(7)
  println(s"fib: ${fibs.toList}")
