import scala.collection.immutable.TreeMap

@main def m(args: String*) =
  var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
  tm += (2 -> 'x')
  println(s"tm: $tm")
