@main def m(args: String*) =
  // Example of repeated paramters
  def echo(args: String*) =
    for arg <- args do println(arg)

  println("echo 'Hello World!':")
  echo(Seq("Hello", "World!")*)

  // Example of named parameters
  def speed(distance: Float, time: Float) = distance / time
  println(s"Speed: ${speed(time = 10, distance = 100)}")

  // Example of default parameters
  def point(x: Int = 0, y: Int = 0) = (x, y)
  println(s"point 1: ${point(x = 42)}")
  println(s"point 2: ${point(y = 1000)}")
