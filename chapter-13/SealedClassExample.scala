@main def m(args: String*) =
  println("Sealed Class Example")
  sealedClassPattern(Var("x"))

sealed trait Expr
case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

def sealedClassPattern(expr: Expr) =
  expr match
    case Num(_) => println("a number")
    case Var(_) => println("a variable")
    case UnOp(_, _) => println("an unop")
    case BinOp(_, _, _) => println("a binop")
