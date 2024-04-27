@main def m(args: String*) =
  var jetSet = Set("Boeing", "Airbus")
  jetSet += "Lear"
  val query = jetSet.contains("Cessna")
  println(s"Jet Set contain 'Cessna': $query")
