@main def m(args: String*) =
  println(s"lazyZip.map: ${(List(10, 20).lazyZip(List(3, 4, 5))).map(_ * _)}")
  println(s"lazyZip.forall: ${(List("abc", "de").lazyZip(List(3, 2))).forall(_.length == _)}")
  println(s"lazyZip.exists: ${(List("abc", "de").lazyZip(List(3, 2))).exists(_.length != _)}")
