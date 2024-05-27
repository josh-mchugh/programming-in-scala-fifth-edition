@main def m(args: String*) =
  println("Abstract Var Example")

abstract class Fruit:
  val v: String // 'v' for value
  def m: String // 'm' for method

abstract class Apple extends Fruit:
  val v: String
  val m: String // OK to override a 'def' with a 'val'

abstract class BadApple extends Fruit:
  def v: String // Error: cannot override a 'val' with a 'def'
  def m: String

trait AbstractTime:
  var hour: Int
  var minute: Int

trait AbstractTimeV2:
  def hour: Int             // getter for 'hour'
  def hour_=(x: Int): Unit  // setter for 'hour'
  def minute: Int           // getter for 'minute'
  def minute_=(x: Int): Unit// setter for 'minute'

