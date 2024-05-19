import scala.collection.mutable.ArrayBuffer

@main def m(args: String*) =
  val buf = new ArrayBuffer[Int]()
  buf += 12
  buf += 15
  println(s"buf.length: ${buf.length}")
  println(s"buf(0): ${buf(0)}")

