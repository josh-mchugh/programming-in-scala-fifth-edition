@main def m(args: String*) =
  def bang(x: Int): Int =
    if x == 0 then throw new Exception("bang!")
    else bang(x - 1) + 1

  bang(3)
