import scala.language.strictEquality

@main def m(args: String*) =
  println("Multiversal Equality")
  val appleTwo = Apple(2)
  val appleTwoToo = Apple(2)
  println(s"appleTwo == appleTwoToo: ${appleTwo == appleTwoToo}")

  val orangeTwo = Orange(2)
  println(s"appleTwo == orangeTwo: ${appleTwo == orangeTwo}")

case class Apple(size: Int)

object Apple:
  given canEqApple: CanEqual[Apple, Apple] = CanEqual.derived
  given canEqOrange: CanEqual[Apple, Orange] = CanEqual.derived

case class Orange(size: Int)





