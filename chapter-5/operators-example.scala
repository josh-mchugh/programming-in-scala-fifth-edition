import scala.language.postfixOps

@main def m(args: String*) =
  assert((1 + 2) == (1.+(2)))
  assert((1 + 2L) == 1.+(2L))

  val s = "Hello, world!"
  assert((s indexOf 'o') == 4)
  assert((s toLowerCase) == "hello, world!")
