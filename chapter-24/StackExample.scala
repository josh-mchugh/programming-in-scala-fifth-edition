@main def m(args: String*) =
  println("Stack Example")

  val stack = new scala.collection.mutable.Stack[Int]
  println(s"stack.push(1): ${stack.push(1)}")
  println(s"stack: $stack")
  println(s"stack.push(2): ${stack.push(2)}")
  println(s"stack: $stack")
  println(s"stack.pop: ${stack.pop}")
  println(s"stack: $stack")
