@main def m(args: String*) =
  println("Mutable Queue")

  val queue = new scala.collection.mutable.Queue[String]
  println(s"queue += \"a\": ${queue += "a"}")
  println(s"queue ++= List(\"b\", \"c\"): ${queue ++= List("b", "c")}")
  println(s"queue: $queue")
  println(s"queue.dequeue: ${queue.dequeue}")
  println(s"queue: $queue")
