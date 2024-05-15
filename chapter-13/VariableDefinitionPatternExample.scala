@main def m(args: String*) =
  val tuple = (123, "abc")
  val (number, string) = tuple
  println(s"number: $number")
  println(s"string: $string")

  val exp = new BinOp("*", Num(5), Num(1))
  val BinOp(op, left, right) = exp
  println(s"op: $op")
  println(s"left: $left")
  println(s"right: $right")

sealed trait Expr
case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
