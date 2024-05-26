import Eastwood.*
import Seinfeld.*
import Literal.*

@main def m(args: String*) =
  println("Algebraic Data Types")
  val eastWood = Good(41)
  println(s"eastwood: ${eastWood.map(n => n + 1)}")

  val xs = 1 :: 2 :: 3 :: Nada
  println(s"xs: $xs")

  println(s"value of literal 'true': ${valueOfLiteral(BooleanLit(true))}")
  println(s"value of literal int: ${valueOfLiteral(IntLit(42))}")

  def valueOfLiteral[T](lit: Literal[T]): T =
    lit match
      case IntLit(n) => n
      case LongLit(m) => m
      case CharLit(c) => c
      case FloatLit(f) => f
      case DoubleLit(d) => d
      case BooleanLit(b) => b
      case StringLit(s) => s


enum Eastwood[+G, +B]:
  def map[G2](f: G => G2): Eastwood[G2, B]=
    this match
      case Good(g) => Good(f(g))
      case Bad(b) => Bad(b)
      case Ugly(ex) => Ugly(ex)

  case Good(g: G)
  case Bad(b: B)
  case Ugly(ex: Throwable)

enum Seinfeld[+E]:
  def ::[E2 >: E](o: E2): Seinfeld[E2] = Yada(o, this)
  case Yada(head: E, tail: Seinfeld[E])
  case Nada

enum Literal[T]:
  case IntLit(value: Int) extends Literal[Int]
  case LongLit(value: Long) extends Literal[Long]
  case CharLit(value: Char) extends Literal[Char]
  case FloatLit(value: Float) extends Literal[Float]
  case DoubleLit(value: Double) extends Literal[Double]
  case BooleanLit(value: Boolean) extends Literal[Boolean]
  case StringLit(value: String) extends Literal[String]







