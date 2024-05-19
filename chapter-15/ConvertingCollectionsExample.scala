import scala.collection.immutable.TreeSet
import scala.collection.mutable

@main def m(args: String*) =
  val colors = List("blue", "yellow", "red", "green")
  println(s"colors to TreeSet: ${colors to TreeSet}")
  val treeSet = colors to TreeSet
  println(s"treeSet.toList: ${treeSet.toList}")
  println(s"treeSet.toArray: ${treeSet.toArray}")


  println(s"treeSet to mutable.Set: ${treeSet to mutable.Set}")
  val mutaSet = treeSet to mutable.Set
  println(s"mutaSet to Set: ${mutaSet to Set}")

  val muta = mutable.Map("i" -> 1, "ii" -> 2)
  println(s"mutable map to Map: ${muta to Map}")
