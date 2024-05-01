object App:
  def main(args: Array[String]): Unit =
    val oneHalf = Rational(1, 2)
    val twoThirds = Rational(2, 3)
    println(s"add $oneHalf and $twoThirds = ${oneHalf + twoThirds}")
    println(s"multiply $oneHalf and $twoThirds = ${oneHalf * twoThirds}")
    println(s"which is greater $oneHalf or $twoThirds: ${oneHalf.max(twoThirds)}")
    println(s"whole number ${new Rational(3)}")
    println(s"normalized ${new Rational(66, 42)}")

class Rational(n: Int, d: Int):
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  override def toString = s"$numer/$denom"

  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

  def + (that: Rational): Rational =
    Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def * (that: Rational): Rational =
    Rational(numer * that.numer, denom * that.denom)

  def lessThan(that: Rational): Boolean =
    numer * that.denom < that.numer * denom

  def max(that: Rational): Rational =
    if lessThan(that) then that else this
