@main def m(args: String*) =
  println("Divide and Conquer")
  println(s"${append(List(1, 2, 3), List(4, 5, 6))}")

  def append[T](xs: List[T], ys: List[T]): List[T] =
    xs match
      case List() => ys
      case x :: xs1 => x :: append(xs1, ys)
