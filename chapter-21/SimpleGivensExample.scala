import JillsPrefs.{prompt as jillPrompt}
import JoesPrefs.{prompt, drink}

@main def m(args: String*) =
  println("Simple Givens")
  Greeter.greet("Jill")(using jillPrompt)
  Greeter.greet("Joe")(using prompt, drink)

class PreferredPrompt(val preference: String)
class PreferredDrink(val preference: String)

object Greeter:
  def greet(name: String)(using prompt: PreferredPrompt, drink: PreferredDrink) =
    println(s"Welcome, $name. The system is ready.")
    print("But while you work, ")
    println(s"why not enjoy a cup of ${drink.preference}?")
    println(prompt.preference)

object JillsPrefs:
  given prompt: PreferredPrompt = PreferredPrompt("Your wish> ")

object JoesPrefs:
  given prompt: PreferredPrompt = PreferredPrompt("relax> ")
  given drink: PreferredDrink = PreferredDrink("tea")

