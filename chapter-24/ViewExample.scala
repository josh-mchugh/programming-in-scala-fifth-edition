@main def m(args: String*) =
  println("View Example")

  val v = Vector((1 to 10)*)
  println(s"v: $v")
  val vv = v.view
  println(s"vv: $vv")
  val vvm = vv.map(_ + 1)
  println(s"vvm: $vvm")
  val vvmm = vvm.map(_ * 2)
  println(s"vvmm: $vvmm")
  val nv = vvmm.toVector
  println(s"nv: $nv")
