@main def m(args: String*) =
  val frog = new Frog
  println(frog.philosophize)

trait Philosophical:
  def philosophize = "I consome memory, therefore I am!"

class Animal

trait HasLegs

class Frog extends Animal, Philosophical, HasLegs:
  override def toString = "green"
  override def philosophize = s"It ain't easy being $this"
