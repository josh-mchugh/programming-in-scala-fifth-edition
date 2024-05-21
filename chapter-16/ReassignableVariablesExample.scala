@main def m(args: String*) =
  val time = Time()
  time.hour_=(23)
  time.minute_=(27)
  println(s"time: $time")

  val t = new Thermometer
  println(s"t: $t")
  println(s"celsius: ${t.celsius}")
  println(s"fahrenheit: ${t.fahrenheit}")

class Time:
  private var h = 12
  private var m = 0

  def hour: Int = h
  def hour_=(x: Int) =
    require(0 <= x && x < 24)
    h = x

  def minute: Int = m
  def minute_=(x: Int) =
    require(0 <= x && x < 60)
    m = x

  override def toString = s"$h:$m"
end Time

import scala.compiletime.uninitialized

class Thermometer:
  var celsius: Float = uninitialized

  def fahrenheit = celsius * 9 / 5 + 32
  def fahrenheit_=(f: Float) =
    celsius = (f - 32) * 5 / 9

  override def toString = s"${fahrenheit}F/${celsius}C"
