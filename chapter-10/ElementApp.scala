@main def m(args: String*) =
  println(Spiral.spiral(17, 0))

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
