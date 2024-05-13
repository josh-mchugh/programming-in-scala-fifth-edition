@main def m(args: String*) =
  println("Hello Case Class")

  val v = Var("x")
  val op = BinOp("+", Num(1), v)
  println(s"v.name: ${v.name}")
  println(s"op.left: ${op.left}")
  println(s"op.toString: ${op.toString}")
  println(s"op.right == Var(\"x\"): ${op.right == Var("x")}")
  println(s"op.copy(operator = \"-\"): ${op.copy(operator = "-")}")

trait Expr
case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
