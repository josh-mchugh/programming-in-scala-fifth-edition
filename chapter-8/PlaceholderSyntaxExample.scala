@main def m(args: String*) =
  val someNumbers = List(-11, -10, -5, 0, 5, 10)
  println("Print some numbers:")
  someNumbers.foreach(println)
  println(s"Filter some numbers: ${someNumbers.filter(_ > 0)}")

  val add = (_: Int) + (_: Int)
  println(s"Added 4 and 6: ${add(4, 6)}")
