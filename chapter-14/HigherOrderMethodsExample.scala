@main def m(args: String*) =
  val words = List("the", "quick", "brown", "fox")
  val numbers = List(1, 2, 3, -4, 5)
  println(s"map: ${words.map(_.length)}")
  println(s"flatMap: ${words.flatMap(_.toList)}")
  println(s"range: ${List.range(1, 5)}")
  println(s" <- foreach: ${words.foreach(word => print(word))}")
  println(s"filter: ${words.filter(_.length == 3)}")
  println(s"partition: ${words.partition(_.length == 3)}")
  println(s"find: ${words.find(_.length == 5)}")
  println(s"takeWhile: ${numbers.takeWhile(_ > 0)}")
  println(s"dropWhile: ${words.dropWhile(_.startsWith("t"))}")
  println(s"span: ${numbers.span(_ > 0)}")
  println(s"exists: ${numbers.exists(_ > 0)}")
  println(s"forall: ${words.forall(_.length < 4)}")
  println(s"foldLeft: ${words.foldLeft("")(_ + " " + _)}")
  println(s"foldRight: ${words.foldRight("")(_ + " " + _)}")
  println(s"reserseLeft: ${reverseLeft(numbers)}")
  println(s"sortWith: ${numbers.sortWith(_ < _)}")
  println(s"List.apply: ${List.apply(1, 2, 3)}")
  println(s"List.range: ${List.range(9, 1, -3)}")
  println(s"List.fill: ${List.fill(3)("hello")}")
  // squares
  println(s"List.tabulate: ${List.tabulate(5)(n => n * n)}")
  // multiplication
  println(s"List.tabulate: ${List.tabulate(5, 5)(_ * _)}")
  println(s"List.concat: ${List.concat(List('a'), List('b'), List('c', 'd'))}")

// a linear complexity reverse function
def reverseLeft[T](xs: List[T]) =
  xs.foldLeft(List[T]()) { (ys, y) => y :: ys }
