import JillsPrefs.{prompt as jillPrompt}
import JoesPrefs.{prompt as tomPrompt, drink as tomDrink}
import TomsPrefs.prompt // imports prompt
import TomsPrefs.given // imports prompt, drink, prefPromptOrd, and prefDrinkOrd
import TomsPrefs.{given PreferredDrink} // imports drink because it is given of type PreferredDrink
import TomsPrefs.{given Ordering[PreferredPrompt], given Ordering[PreferredDrink]} // imports prefPromptOrd and prefDrinkOrd
import TomsPrefs.{given Ordering[?]} // imports prefPromptOrd and preDrinkOrd

@main def m(args: String*) =
  println("Simple Givens")
  Greeter.greet("Jill")(using jillPrompt)
  Greeter.greet("Joe")(using tomPrompt, tomDrink)

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

object TomsPrefs:
  val favoriteColor = "blue"
  def favoriteFood = "steak"

  given prompt: PreferredPrompt = PreferredPrompt("enjoy>")
  given drink: PreferredDrink = PreferredDrink("red whine")
  given prefPromptOrd: Ordering[PreferredPrompt] with
    def compare(x: PreferredPrompt, y: PreferredPrompt) =
      x.preference.compareTo(y.preference)
  given prefDrinkOrd: Ordering[PreferredDrink] with
    def compare(x: PreferredDrink, y: PreferredDrink) =
      x.preference.compareTo(y.preference)




