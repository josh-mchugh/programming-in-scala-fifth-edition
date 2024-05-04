@main def m(args: String*) =
  val firstArg = if !args.isEmpty then args(0) else ""
  val friend =
    firstArg match
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
  println(friend)
