@main def m(args: String*) =
  println("Hello Export")
  val x = PosInt(99)
  println(s"x + 1 = ${x + 1}")
  println(s"x - 1 = ${x - 1}")
  println(s"x / 3 = ${x / 3}")

  val y = PosInt(24)
  println(s"shift left 1: ${y shl 1}")
  println(s"shift right 1: ${y shr 1}")
  println(s"unasigned shift right: ${y ushr 1}")

case class PosInt(value: Int):
  require(value > 0)
  export value.{<< as shl, >> as shr, >>> as ushr, *}
