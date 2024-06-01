@main def m(args: String*) =
  println("Generic Extension Example")
  println(s"List(1, 2, 3).tailOption: ${List(1, 2, 3).tailOption}")
  println(s"List.empty[Int].tailOption: ${List.empty[Int].tailOption}")
  println(s"List.(\"A\", \"B\", \"C\").tailOption: ${List("A", "B", "C").tailOption}")
  println(s"List.empty[String].tailOption: ${List.empty[String].tailOption}")

extension [T](xs: List[T])
  def tailOption: Option[List[T]] =
    if xs.nonEmpty then Some(xs.tail) else None






