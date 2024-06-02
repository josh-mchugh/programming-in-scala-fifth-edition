@main def m(args: String*) =
  println("Queue Example")

  val empty = scala.collection.immutable.Queue[Int]()
  val has1 = empty.enqueue(1)
  val has123 = has1.enqueueAll(List(2, 3))

  println(s"has123.dequeue: ${has123.dequeue}")
