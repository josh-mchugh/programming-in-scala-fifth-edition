@main def m(args: String*) =
  println("Debugging Example")
  Mocha.callEnjoy
  // run: scalac -Xprint:typer DebuggingExample.scala

object Mocha:
  class PreferredDrink(val preference: String)
  given pre: PreferredDrink = new PreferredDrink("mocha")

  def enjoy(name: String)(using drink: PreferredDrink): Unit =
    print(s"Welcome $name")
    print(". Enjoy a ")
    print(drink.preference)
    println("!")

  def callEnjoy: Unit = enjoy("reader")
