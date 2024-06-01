@main def m(args: String*) =
  println("Collective Extension Example")
  println(s"42.absOption: ${42.absOption}")
  println(s"-42.absOption: ${-42.absOption}")
  println(s"Int.MaxValue.absOption: ${Int.MaxValue.absOption}")
  println(s"Int.MinValue.absOption: ${Int.MinValue.absOption}")
  println(s"-42.negateOption: ${-42.negateOption}")
  println(s"42.negateOption: ${42.negateOption}")
  println(s"Int.MaxValue.negateOption: ${Int.MaxValue.negateOption}")
  println(s"Int.MinValue.negateOption: ${Int.MinValue.negateOption}")

extension (n: Int)
  def isMinValue: Boolean = n == Int.MinValue
  def absOption: Option[Int] =
    if !isMinValue then Some(n.abs) else None
  def negateOption: Option[Int] =
    if !isMinValue then Some(-n) else None



