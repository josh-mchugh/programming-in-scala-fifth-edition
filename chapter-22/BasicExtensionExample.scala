@main def m(args: String*) =
  println("Basic Extension Example")
  val s = "One  Fish, Two\tFish "
  val t = " One Fish,  Two Fish"
  println(s"t == s: ${s.singleSpace == t.singleSpace}")

extension (s: String)
  def singleSpace: String = s.trim.split("\\s+").mkString(" ")





