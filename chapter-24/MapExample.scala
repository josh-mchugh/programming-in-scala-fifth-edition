@main def m(args: String*) =
  println("Map Example")
  
  val cache = collection.mutable.Map[String, String]()
  def cachedF(s: String) = cache.getOrElseUpdate(s, f(s))

  println(s"cachedF(\"abc\"): ${cachedF("abc")}")
  println(s"cachedF(\"abc\"): ${cachedF("abc")}")

  def f(x: String) =
    println("taking my time.")
    Thread.sleep(100)
    x.reverse






