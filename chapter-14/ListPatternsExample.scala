@main def m(args: String*) =
  val fruit = List("apple", "orange", "pear")
  val List(a, b, c) = fruit
  println(s"a: $a")
  println(s"b: $b")
  println(s"c: $c")

  val d :: e :: rest = fruit
  println(s"d: $d")
  println(s"e: $e")
  println(s"rest: $rest")

  val numbers = List(5, 8, 2,  3, 3, 8, 1, 9, 4)
  println(s"numbers: ${isort(numbers).mkString(",")}")

  def isort(xs: List[Int]): List[Int] =
    xs match
      case List() => List()
      case x :: xs1 => insert(x, isort(xs1))

  def insert(x: Int, xs: List[Int]): List[Int] =
    xs match
      case List() => List(x)
      case y :: ys => if x <= y then x :: xs
                      else y :: insert(x, ys)
