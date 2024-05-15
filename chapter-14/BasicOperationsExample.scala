@main def m(args: String*) =
  val numbers = List(5, 8, 2,  3, 3, 8, 1, 9, 4)
  println(isort(numbers).mkString(", "))

  def isort(xs: List[Int]): List[Int] =
    if xs.isEmpty then Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] =
    if xs.isEmpty || x <= xs.head then x :: xs
    else xs.head :: insert(x, xs.tail)
