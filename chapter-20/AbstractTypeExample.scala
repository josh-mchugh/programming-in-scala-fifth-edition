@main def m(args: String*) =
  println("Abstract Type Example")
  val bessy = new Cow
  val lassie = new Dog
  val bootsie = new Dog
  lassie.eat(new bootsie.SuitableFood)

  val o1 = new Outer
  val o2 = new Outer
  val o1Inner = new o1.Inner
  //new Outer#Inner // does not work compile, Outer is not a vailid class path prefix

class Food
abstract class Animal:
  type SuitableFood <: Food
  def eat(food: SuitableFood): Unit

class Grass extends Food
class Fish extends Food
class Cow extends Animal:
  type SuitableFood = Grass
  override def eat(food: Grass) = {}

class DogFood extends Food
class Dog extends Animal:
  type SuitableFood = DogFood
  override def eat(food: DogFood) = {}

class Outer:
  class Inner

