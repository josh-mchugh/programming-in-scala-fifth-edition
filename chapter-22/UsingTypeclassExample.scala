@main def m(args: String*) =
  println("Using Typeclass Example")
  println(s"Byte.MaxValue.negateOption: ${Byte.MaxValue.negateOption}")
  println(s"Byte.MinValue.negateOption: ${Byte.MinValue.negateOption}")
  println(s"Long.MaxValue.negateOption: ${Long.MaxValue.negateOption}")
  println(s"Long.MinValue.negateOption: ${Long.MinValue.negateOption}")
  // BigInt(42).negateOption // Does not work, BigInt not of TwoComplement typeclass

extension [N](n: N)(using tc: TwoComplement[N])
  def isMinValue: Boolean = tc.equalsMinValue(n)
  def absOption: Option[N] =
    if !isMinValue then Some(tc.absOf(n)) else None
  def negateOption: Option[N] =
    if !isMinValue then Some(tc.negationOf(n)) else None

trait TwoComplement[N]:
  def equalsMinValue(n: N): Boolean
  def absOf(n: N): N
  def negationOf(n: N): N

object TwoComplement:
  given tcOfByte: TwoComplement[Byte] with
    def equalsMinValue(n: Byte) = n == Byte.MinValue
    def absOf(n: Byte) = n.abs
    def negationOf(n: Byte) = (-n).toByte

  given tcOfShort: TwoComplement[Short] with
    def equalsMinValue(n: Short) = n == Short.MinValue
    def absOf(n: Short) = n.abs
    def negationOf(n: Short) = (-n).toShort

  given tcOfInt: TwoComplement[Int] with
    def equalsMinValue(n: Int) = n == Int.MinValue
    def absOf(n: Int) = n.abs
    def negationOf(n: Int) = -n

  given tcOfLong: TwoComplement[Long] with
    def equalsMinValue(n: Long) = n == Long.MinValue
    def absOf(n: Long) = n.abs
    def negationOf(n: Long) = -n





