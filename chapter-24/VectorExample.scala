@main def m(args: String*) =
  println("Vector Example")

  val vec = scala.collection.immutable.Vector.empty
  val vec2 = vec :+ 1 :+ 2
  val vec3 = 100 +: vec2
  println(s"vec: $vec")
  println(s"vec2: $vec2")
  println(s"vec3: $vec3")

  val vec4 = Vector(1, 2, 3)
  println(s"vec4: $vec4")
  println(s"vec4.updated(2, 4): ${vec4.updated(2, 4)}")
  println(s"vec4: $vec4")

