@main def m(args: String*) =
  var i = 1
  while i <= 10 do
    var j = 1
    while j <= 10 do
      val prod = (i * j).toString
      var k = prod.length
      while k < 4 do
        print(" ")
        k += 1
      print(prod)
      j += 1
    println()
    i += 1
