@main def m(args: String*) =
  println("Hello Companions")

// Example how Companion objects and classes can
// access each others private or protected members.
class Rocket:
  import Rocket.fuel
  private def canGoHomeAgain = fuel > 20

object Rocket:
  private def fuel = 10
  def chooseStrategy(rocket: Rocket) =
    if rocket.canGoHomeAgain then
      goHome()
    else
      pickAStar()
  def goHome() = {}
  def pickAStar() = {}
