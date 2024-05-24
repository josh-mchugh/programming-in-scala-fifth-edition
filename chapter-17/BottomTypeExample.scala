@main def m(arg: String*) =
  // Nothing can be a return type
  def error(message: String): Nothing =
    throw new Exception(message)
  // Nothing is a subclass of all types
  def divide(x: Int, y: Int): Int =
    if y != 0 then x / y
    else sys.error("can't divide by zero")








