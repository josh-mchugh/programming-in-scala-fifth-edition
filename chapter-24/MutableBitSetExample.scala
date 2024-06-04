@main def m(args: String*) =
  println("Mutable BitSet Example")

  val bits = scala.collection.mutable.BitSet.empty
  println(s"bits += 1: ${bits += 1}")
  println(s"bits += 3: ${bits += 3}")
  println(s"bits: $bits")
