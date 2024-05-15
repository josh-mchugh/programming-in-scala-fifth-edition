@main def m(args: String*) =
  val f = new ExprFormatter
  val e1 = BinOp("*", BinOp("/", Num(1), Num(2)),
                      BinOp("+", Var("x"), Num(1)))

  val e2 = BinOp("+", BinOp("/", Var("x"), Num(2)),
                      BinOp("/", Num(1.5), Var("x")))

  val e3 = BinOp("/", e1, e2)

  def show(e: Expr) = println(s"${f.format(e)}\n\n")
  for e <- Vector(e1, e2, e3) do show(e)

class ExprFormatter:
  // Contains operators in groups of increasing precedence
  private val opGroups =
    Vector(
      Set("|", "||"),
      Set("&", "&&"),
      Set("^"),
      Set("==", "!="),
      Set("<", "<=", ">", ">="),
      Set("+", "-"),
      Set("*", "%")
    )

  // A mapping from operators to their precedence
  private val precedence = {
    val assocs =
      for
        i <- 0 until opGroups.length
        op <- opGroups(i)
      yield op -> i
    assocs.toMap
  }

  private val unaryPrecedence = opGroups.length
  private val fractionPrecedence = -1

  private def format(e: Expr, enclPrec: Int): Element =
    e match
      case Var(name) =>
        Element.elem(name)
      case Num(number) =>
        def stripDot(s: String) =
          if s endsWith ".0" then s.substring(0, s.length - 2)
          else s
        Element.elem(stripDot(number.toString))
      case UnOp(op, arg) =>
        Element.elem(op) beside format(arg, unaryPrecedence)
      case BinOp("/", left, right) =>
        val top = format(left, fractionPrecedence)
        val bot = format(right, fractionPrecedence)
        val line = Element.elem('-', top.width.max(bot.width), 1)
        val frac = top above line above bot
        if enclPrec != fractionPrecedence then frac
        else Element.elem(" ") beside frac beside Element.elem(" ")
      case BinOp(op, left, right) =>
        val opPrec = precedence(op)
        val l = format(left, opPrec)
        val r = format(right, opPrec + 1)
        val oper = l beside Element.elem(" " + op + " ") beside r
        if enclPrec <= opPrec then oper
        else Element.elem("(") beside oper beside Element.elem(")")
    end match
  def format(e: Expr): Element = format(e, 0)
end ExprFormatter
sealed trait Expr
case class Var(name: String) extends Expr
case class Num(number: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

abstract class Element:

  def contents: Vector[String]

  def height: Int = contents.length

  def width: Int =
    if height == 0 then 0 else contents(0).length

  def above(that: Element): Element =
    val this1 = this.widen(that.width)
    val that1 = that.widen(this.width)
    Element.elem(this1.contents ++ that1.contents)

  def beside(that: Element): Element =
    val this1 = this.heighten(that.height)
    val that1 = that.heighten(this.height)
    val result =
      for (line1, line2) <- this1.contents.zip(that1.contents)
      yield line1 + line2
    Element.elem(result)

  def widen(w: Int): Element =
    if w <= width then this
    else
      val left = Element.elem(' ', (w - width) / 2, height)
      val right = Element.elem(' ', w - width - left.width, height)
      left beside this beside right

  def heighten(h: Int): Element =
    if h <= height then this
    else
      val top = Element.elem(' ', width, (h - height) / 2)
      val bot = Element.elem(' ', width, h - height - top.height)
      top above this above bot

  override def toString = contents.mkString("\n")
end Element

object Element:
  private class VectorElement(
    val contents: Vector[String]
  ) extends Element

  private class LineElement(s: String) extends Element:
    val contents = Vector(s)
    override def width = s.length
    override def height = 1

  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
  ) extends Element:
    private val line = ch.toString * width
    def contents = Vector.fill(height)(line)

  def elem(contents: Vector[String]): Element =
    VectorElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    UniformElement(chr, width, height)

  def elem(line: String): Element =
    LineElement(line)
end Element


object Spiral:
  val space = Element.elem(" ")
  val corner = Element.elem("+")

  def spiral(nEdges: Int, direction: Int): Element =
    if nEdges == 1 then
      Element.elem("+")
    else
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = Element.elem('|', 1, sp.height)
      def horizontalBar = Element.elem('-', sp.width, 1)

      if direction == 0 then
        (corner beside horizontalBar) above (sp beside space)
      else if direction == 1 then
        (sp above space) beside (corner above verticalBar)
      else if direction == 2 then
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
end Spiral
