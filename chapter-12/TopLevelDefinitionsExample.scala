import bobsdelights.Fruits
import bobsdelights.showFruit

@main def m(args: String*) =
  println(
    for fruit <- Fruits.menu yield
      showFruit(fruit)
  )

package bobsdelights:
  def showFruit(fruit: Fruit) =
    import fruit.*
    s"${name}s are $color"

  abstract class Fruit(
    val name: String,
    val color: String
  )

  object Fruits:
    object Apple extends Fruit("apple", "red")
    object Orange extends Fruit("orange", "orange")
    object Pear extends Fruit("pear", "yellowish")
    val menu = List(Apple, Orange, Pear)

