@main def m(args: String*) =
  val increase = (x: Int) => x + 1
  println(s"Increment vale 2 by 1: ${increase(2)}")

  val increase2 = (x: Int) =>
    val increment = 2
    x + increment
  println(s"Inecrement value 4 by 2: ${increase2(4)}")

  val someNumbers = List(-11, -10, -5, 0, 5, 10)
  println("Print some numbers:")
  someNumbers.foreach(x => println(x))
  println(s"Filter some numbers: ${someNumbers.filter(x => x > 0)}")
