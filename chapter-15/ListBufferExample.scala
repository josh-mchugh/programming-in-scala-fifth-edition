import scala.collection.mutable.ListBuffer

@main def m(args: String*) =
  val buf = new ListBuffer[Int]
  buf += 1
  buf += 2
  3 +=: buf
  println(s"buf.toList: ${buf.toList}")


