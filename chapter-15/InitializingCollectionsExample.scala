@main def m(args: String*) =
  List(1, 2, 3)
  Set('a', 'b', 'c')
  import scala.collection.mutable
  mutable.Map("hi" -> 2, "there" -> 5)
  Array(1.0, 2.0, 3.0)

  val stuff = mutable.Set[Any](42)
  stuff += "abracadabra"

  val colors = List("blue", "yellow", "red", "green")

  import scala.collection.immutable.TreeSet
  val treeSet = colors to TreeSet
