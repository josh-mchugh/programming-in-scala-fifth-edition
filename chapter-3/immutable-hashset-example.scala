import scala.collection.immutable.HashSet

@main def m(args: String*) =
  val hashSet = HashSet("Tomatoes", "Chilies")
  val ingredients = hashSet + "Coriander"
  println(s"Ingredients: $ingredients")
