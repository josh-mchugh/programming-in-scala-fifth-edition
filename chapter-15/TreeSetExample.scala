import scala.collection.immutable.TreeSet

@main def m(args: String*) =
  val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
  println(s"ts: $ts")
  val cs = TreeSet('f', 'u', 'n')
  println(s"cs: $cs")
