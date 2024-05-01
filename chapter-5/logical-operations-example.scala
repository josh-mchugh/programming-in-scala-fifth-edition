object App:
  def main(args: Array[String]): Unit =
    println(s"pepper and salt? ${pepper() && salt()}")
    println(s"salt and pepper? ${salt() && pepper()}")

  def salt() =
    println("salt")
    false

  def pepper() =
    println("pepper")
    true
