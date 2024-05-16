@main def m(args: String*) =
  val numbers = List(1, 2, 3)
  println(s"numbers: ${numbers}")
  println(s"length: ${numbers.length}")
  println(s"last: ${numbers.last}")
  println(s"init: ${numbers.init}")
  println(s"reverse: ${numbers.reverse}")
  println(s"rev: ${rev(numbers)}")
  println(s"take(1): ${numbers.take(1)}")
  println(s"drop(1): ${numbers.drop(1)}")
  println(s"splitAt(1): ${numbers.splitAt(1)}")
  println(s"indices: ${numbers.indices}")
  println(s"flatten: ${List(numbers, numbers, numbers).flatten}")
  println(s"zip: ${numbers.indices.zip(numbers)}")
  println(s"unzip: ${numbers.indices.zip(numbers).unzip}")
  println(s"toString: ${numbers.toString}")
  println(s"mkString: ${numbers.mkString("[", ",", "]")}")
  println(s"toArray: ${numbers.toArray}")
  println(s"toList: ${numbers.toArray.toList}")

// Implementation of reverse with concatenation.
// Not a very efficientand quadratic to the lenth of it's input.
def rev[T](xs: List[T]): List[T] =
  xs match
    case List() => xs
    case x :: xs1 => rev(xs1) ::: List(x)
