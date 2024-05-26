import Direction.{North, South, East, West}

@main def m(args: String*) =
  println("Enum Example")
  println(s"invert North: ${North.invert}")
  println(s"east ordinal: ${East.ordinal}")
  println(s"value of West: ${Direction.valueOf("West")}")
  println(s"South degress: ${South.degrees}")
  println(s"all but nearest: ${allButNearest(42)}")
  println(s"java compareTo: ${East.compareTo(South)}")

  def allButNearest(degrees: Int): List[Direction] =
    val nearest = Direction.nearestTo(degrees)
    Direction.values.toList.filter(_ != nearest)

enum Direction(val degrees: Int) extends java.lang.Enum[Direction]:
  def invert: Direction =
    this match
      case North => South
      case East => West
      case South => North
      case West => East

  case North extends Direction(0)
  case East extends Direction(90)
  case South extends Direction(180)
  case West extends Direction(270)

object Direction:
  def nearestTo(degrees: Int): Direction =
    val rem = degrees % 360
    val angle = if rem < 0 then rem + 360 else rem
    val (ne, se, sw, nw) = (45, 135, 225, 315)
    angle match
      case a if a > nw || a <= ne => North
      case a if a > ne && a <= se => East
      case a if a > se && a <= sw => South
      case a if a > sw && a <= nw => West






