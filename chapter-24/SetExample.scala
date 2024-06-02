@main def m(args: String*) =
  println("Set Example")
  val fruit = Set("apple", "orange", "peach", "banana")
  println(s"fruit(\"peach\"): ${fruit("peach")}")
  println(s"fruit(\"potato\"): ${fruit("potato")}")

  var s = Set(1, 2, 3)
  s += 4
  s -= 2
  println(s"s: $s")

  var m = collection.mutable.Set(1, 2, 3)
  m += 4
  m -= 2
  println(s"m: $m")
