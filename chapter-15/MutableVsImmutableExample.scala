import scala.collection.mutable.Map

@main def m(args: String*) =
  var people = Set("Nancy", "Jane")
  people += "Bob"
  people ++= List("Tom", "Harry")
  println(s"people: $people")

  var captial = Map("US" -> "Washington", "France" -> "Paris")
  captial += ("Japan" -> "Tokyo")
  println(captial("France"))
