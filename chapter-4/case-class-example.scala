@main def m(args: String*) =
  val p = Person("sally", 39)
  println(s"name: ${p.name}")
  println(s"age: ${p.age}")
  println(s"toString: ${p.toString}")
  println(s"hashCode: ${p.hashCode}")
  println(s"equals: ${p == Person("Sally", 39)}")
  println(s"appendToName: ${p.appendToName(" Smith")}")

case class Person(name: String, age: Int):
  def appendToName(suffix: String): Person =
    Person(s"$name$suffix", age)

object Person:
  def apply(name: String, age: Int): Person =
    val capitalizedName =
      if !name.isEmpty then
        val firstChar = name.charAt(0).toUpper
        val restOfName = name.substring(1)
        s"$firstChar$restOfName"
      else throw new IllegalArgumentException("Empty name")
    new Person(capitalizedName, age)
