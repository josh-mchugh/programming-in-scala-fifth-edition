@main def m(args: String*) =
  propagation()

def propagation(): String =
  throw new IllegalArgumentException("Boom!")
  "test"
