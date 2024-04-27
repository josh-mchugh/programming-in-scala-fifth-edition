import scala.collection.mutable

@main def m(args: String*) =
  val treasureMap = mutable.Map.empty[Int, String]
  treasureMap += (1 -> "Go to island.")
  treasureMap += (2 -> "Find big X on ground.")
  treasureMap += (3 -> "Dig.")
  val step2 = treasureMap(2)
  println(s"What step of finding the treasure are we at: $step2")
