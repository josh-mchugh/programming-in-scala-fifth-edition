@main def m(args: String*) =


package bobsdelights:
  abstract class Fruit(
    val name: String,
    val color: String
  )

  object Fruits:
    object Apple extends Fruit("apple", "red")
    object Orange extends Fruit("orange", "orange")
    object Pear extends Fruit("pear", "yellowish")
    val menu = (Apple, Orange, Pear)

// easy access to Fruit
import bobsdelights.Fruit
// easy access to all members of bobsdelights
import bobsdelights.
// easy access to all members of Fruits
import bobsdelights.Fruits.*

// example of imports within function body
def showFruit(fruit: Fruit) =
  import fruit.*
  s"${name}s are $color"

// example of selector clause
import Fruits.{Apple, Orange}

// example of selector clause
import java.util.regex

class AStarB:
  // Accessess java.util.regex.Pattern
  val pat = regex.Pattern.compile("a*b")

// example of renaming import clause
import Fruits.{Apple as McIntosh, Orange}

import java.sql.Date as SDate

import java.sql as S

import Fruits.{*}
import Fruits.*

// example of importing all and renaming
import Fruits.{Apple as McIntosh, *}

// example of excluding from a package
import Fruits.{Pear as _, *}

// Example of excluding from a list to not conflict names
import Laptops.*
import Fruits.{Apple as _, *}
