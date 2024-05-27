@main def m(args: String*) =
  println("Rational Trait")
  val x = 2
  println(s"rational: ${new RationalTrait(1 * x, 2 * x) {}}")
  val lazyRationalTrait = new LazyRationalTrait:
    val numerArg = 1 * x
    val denomArg = 2 * x
  println(s"lazy rational: ${lazyRationalTrait}")

trait RationalTrait(val numerArg: Int, val denomArg: Int):
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  override def toString = s"$numer/$denom"

trait LazyRationalTrait:
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g
  override def toString = s"$numer/$denom"
  private lazy val g =
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)





