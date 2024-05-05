@main def m(args: String*) =
  def sum (a: Int, b: Int, c: Int) = a + b + c
  val a = sum(_, _, _)
  println(s"sum of partial applied 'a': ${a(1, 2, 3)}")
  val b = sum(1, _, 3)
  println(s"sum of partial applied 'b': ${b(5)}")
  val c = sum
  println(s"sum of partial applied 'c': ${c(10, 20, 30)}")
