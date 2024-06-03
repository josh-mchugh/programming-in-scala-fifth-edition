@main def m(args: String*) =
  println("Bit Set Example")

  val bits = scala.collection.immutable.BitSet.empty
  val moreBits = bits + 3 + 4 + 4
  println(s"moreBits: ${bits + 3 + 4 + 4}")
  println(s"moreBits(3): ${moreBits(3)}")
  println(s"moreBits(0): ${ moreBits(0)}")
