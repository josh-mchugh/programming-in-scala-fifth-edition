@main def m(args: String*) =
  println("Curreny Example")
  val yen = Japan.Yen.from(US.Dollar * 100)
  println(s"yen: $yen")
  val euros = Europe.Euro.from(yen)
  println(s"euros: $euros")
  val dollars = US.Dollar.from(euros)
  println(s"dollars: $dollars")
  println(s"dollars + 100: ${US.Dollar * 100 + dollars}")

object US extends CurrencyZone:
  abstract class Dollar extends AbstractCurrency:
    def designation = "USD"
  type Currency = Dollar
  def make(cents: Long) =
    new Dollar:
      val amount = cents
  val Cent = make(1)
  val Dollar = make(100)
  val CurrencyUnit = Dollar

object Europe extends CurrencyZone:
  abstract class Euro extends AbstractCurrency:
    def designation = "EUR"
  type Currency = Euro
  def make(cents: Long) =
    new Euro:
     val amount = cents
  val Cent = make(1)
  val Euro = make(100)
  val CurrencyUnit = Euro

object Japan extends CurrencyZone:
  abstract class Yen extends AbstractCurrency:
   def designation = "JPY"
  type Currency = Yen
  def make(yen: Long) =
    new Yen:
      val amount = yen
  val Yen = make(1)
  val CurrencyUnit = Yen

abstract class CurrencyZone:
  type Currency <: AbstractCurrency
  def make(x: Long): Currency
  abstract class AbstractCurrency:
    val amount: Long
    def designation: String
    def + (that: Currency): Currency =
      make(this.amount + that.amount)
    def * (x: Double): Currency =
      make((this.amount * x).toLong)
    def - (that: Currency): Currency =
      make(this.amount - that.amount)
    def / (that: Double) =
      make((this.amount / that).toLong)
    def from(other: CurrencyZone#AbstractCurrency): Currency =
      make(math.round(
        other.amount.toDouble * Converter.exchangeRate
          (other.designation)(this.designation)))

    private def decimals(n: Long): Int =
      if (n == 1) 0 else 1 + decimals(n / 10)

    override def toString =
      ((amount.toDouble / CurrencyUnit.amount.toDouble)
        .formatted(s"%.${decimals(CurrencyUnit.amount)}f ${designation}")
      )
  end AbstractCurrency
  val CurrencyUnit: Currency
end CurrencyZone

object Converter:
  var exchangeRate =
    Map(
      "USD" -> Map("USD" -> 1.0, "EUR" -> 0.8498, "JPY" -> 1.047, "CHF" -> 0.9149),
      "EUR" -> Map("USD" -> 1.177, "EUR" -> 1.0, "JPY" -> 1.232, "CHF" -> 1.0765),
      "JPY" -> Map("USD" -> 0.9554, "EUR" -> 0.8121, "JPY" -> 1.0, "CHF" -> 0.8742),
      "CHF" -> Map("USD" -> 1.093, "EUR" -> 0.9289, "JPY" -> 1.144, "CHF" -> 1.0)
    )










