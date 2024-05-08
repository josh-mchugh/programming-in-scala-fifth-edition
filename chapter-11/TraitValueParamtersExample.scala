@main def m(args: String*) =
  val frog = new Frog
  println(frog.philosophize)

  val duck = new Duck
  println(duck.philosophize)

trait Philosophical(message: String):
  def philosophize = message

class Animal

class Frog extends Animal, Philosophical("I croak, therefore I am!")
class Duck extends Animal, Philosophical("I quack, therefore I am!")
