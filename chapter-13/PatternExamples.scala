@main def m(args: String*) =
  println("Hello Patterns")

  println()
  println("Wildcard Patterns")
  wildCardPattern(Var("x"))
  wildCardPattern(BinOp("+", Num(1), Num(2)))

  println()
  println("Constant Patterns")
  constantPattern(5)
  constantPattern(true)
  constantPattern("hello")
  constantPattern(Nil)
  constantPattern(List(1,2,3))

  println()
  println("Variable Patterns")
  variablePattern(math.E)
  variablePattern(math.Pi)

  println()
  println("Constructor Patterns")
  constructorPattern(BinOp("+", Var("e"), Num(0)))

  println()
  println("Sequence Patterns")
  sequencePattern(List(0, 1))  

  println()
  println("Tuple Patterns")
  tuplePattern(("a", "b", "c"))
  tuplePattern(("d", "e"))

  println()
  println("Typed Patterns")
  typedPattern("Test String")
  typedPattern(Map(1 -> 2, 2 -> 1))
  typedPattern(1)

  println()
  println("Variable Binding Patterns")
  variableBindingPattern(UnOp("abs", UnOp("abs", Num(1))))

  println()
  println("Guard Patterns")
  guardPattern(BinOp("+", Num(1), Num(1)))

trait Expr
case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

def wildCardPattern(expr: Expr) =
  expr match
    case BinOp(_, _, _) =>
      println(s"$expr is a binary operation")
    case _ => //handle default case
      println(s"It's something else")

def constantPattern(x: Any) =
  x match
    case 5 => println("five")
    case true => println("truth")
    case "hello" => println("hi!")
    case Nil => println("the empty list")
    case _ => println("something else")

def variablePattern(x: Double) =
  x match
    case math.Pi => println(s"string math? Pi = $x")
    case _ => println("Ok")

def constructorPattern(expr: Expr) =
  expr match
    case BinOp("+", e, Num(0)) => println("a deep match")
    case _ => println("no matchy")

def sequencePattern(xs: List[Int]) =
  xs match
    case List(0, _*) => println("found it")
    case _ => println("not found")

def tuplePattern(obj: Any) =
  obj match
    case (a, b, c) => println(s"matched $a$b$c")
    case (a, b) => println(s"matched $a$b")
    case _ => println("no match")

def typedPattern(x: Any) =
  x match
    case s: String => println(s"${s.length}")
    case m: Map[_, _] => println(s"${m.size}")
    case _ => println(s"-1")

def variableBindingPattern(expr: Expr) =
  expr match
    case UnOp("abs", e @ UnOp("abs", _)) => println(s"$e")
    case _ => println("no match")

def guardPattern(expr: Expr) =
  expr match
    case BinOp("+", x, y) if x == y => println(s"${BinOp("*", x, Num(2))}")
    case _ => println(s"$expr")
