@main def m(args: String*) =
  val plumOrApricot: Plum | Apricot = new Plum {}
  val fruit: Fruit = plumOrApricot

  val pluot = new Pluot {}
  val plumAndApricot: Plum & Apricot = pluot

trait Fruit
trait Plum extends Fruit
trait Apricot extends Fruit
trait Pluot extends Plum, Apricot

def errorMessage(msg: Int | String): String =
  msg match
    case n: Int => s"Error number: ${n.abs}"
    case s: String => s + "!"
