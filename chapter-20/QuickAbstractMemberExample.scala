@main def m(args: String*) =
  println("Quick Abstract Example")

trait Abstract:
  type T
  def transform(x: T): T
  val initial: T
  val current: T

class Concrete extends Abstract:
  type T = String
  def transform(x: String) = x + x
  val initial = "hi"
  val current = initial
