object App:
  def main(args: Array[String]): Unit =
    val oneHalf = Rational(1, 2)
    val twoThirds = Rational(2, 3)
    println(s"add $oneHalf and $twoThirds = ${oneHalf + twoThirds}")
    println(s"add $oneHalf and 2 = ${oneHalf + 2}")
    println(s"subtract $oneHalf and $twoThirds = ${oneHalf - twoThirds}")
    println(s"subtract $oneHalf and 2 = ${oneHalf - 2}")
    println(s"multiply $oneHalf and $twoThirds = ${oneHalf * twoThirds}")
    println(s"multiply $oneHalf and 2 = ${oneHalf * 2}")
    println(s"divide $oneHalf and $twoThirds = ${oneHalf / twoThirds}")
    println(s"divide $oneHalf and 2 = ${oneHalf / 2}")
    println(s"which is greater $oneHalf or $twoThirds: ${oneHalf.max(twoThirds)}")
    println(s"whole number ${new Rational(3)}")
    println(s"normalized ${new Rational(66, 42)}")

class Rational(n: Int, d: Int):
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational =
    Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def + (i: Int): Rational =
    Rational(numer + i * denom, denom)

  def - (that: Rational): Rational =
    Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def - (i: Int): Rational =
    Rational(numer - i * denom, denom)

  def * (that: Rational): Rational =
    Rational(numer * that.numer, denom * that.denom)

  def * (i: Int): Rational =
    Rational(numer * i, denom)

  def / (that: Rational): Rational =
    Rational(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational =
    Rational(numer, denom * i)

  def lessThan(that: Rational): Boolean =
    numer * that.denom < that.numer * denom

  def max(that: Rational): Rational =
    if lessThan(that) then that else this

  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

  override def toString = s"$numer/$denom"
