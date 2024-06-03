import scala.collection.immutable.VectorMap

@main def m(args: String*) =
  println("VectorMap Example")

  val vm = VectorMap.empty[Int, String]
  val vm1 = vm + (1 -> "one")
  println(s"vm1: $vm1")
  val vm2 = vm1 + (2 -> "two")
  println(s"vm2: $vm2")
  println(s"vm2 == Map(2 -> \"two\", 1 -> \"one\"): ${vm2 == Map(2 -> "two", 1 -> "one")}")
