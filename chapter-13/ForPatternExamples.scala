@main def m(args: String*) =
  val captials = Map("France" -> "Paris", "Japan" -> "Tokyo")
  for (country, city) <- captials yield
    println(s"The capital of $country is $city")
