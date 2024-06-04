@main def m(args: String*) =
  println("HashTable Example")

  val map = collection.mutable.HashMap.empty[Int, String]
  println(s"map += (1 -> \"make a web site\"): ${map += (1 -> "make a web site")}")
  println(s"map += (3 -> \"profit!\"): ${map += (3 -> "profit!")}")
  println(s"map(1): ${map(1)}")
  println(s"map.contains(2): ${map.contains(2)}")
