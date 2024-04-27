import scala.collection.mutable

@main def m(args: String*) =
  val movieSet = mutable.Set("Spotlight", "Moonlight")
  movieSet += "Parasite"
  println(s"Movie set: $movieSet")
