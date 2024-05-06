@main def m(args: String*) =
  def curriedSum(x: Int)(y: Int) = x + y
  println(s"curriedSum(1)(2): ${curriedSum(1)(2)}")

  def first(x: Int) = (y: Int) => x + y
  val second = first(1)
  println(s"second(2): ${second(2)}")

  val onePlus = curriedSum(1)
  println(s"onePlus(2): ${onePlus(2)}")

  val twoPlus = curriedSum(2)
  println(s"twoPlus(2): ${twoPlus(2)}")
