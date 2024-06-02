val errmsg =
  "Please enter a word, positive integer count, and \n" +
  "a mood (one of 'angry', 'surprised', or 'neutral')"

@main def echo(word: String, count: Int, mood: Mood) =
  val msg =
    if count > 0 then
      val words = List.fill(count)(word)
      val punc =
        mood match
          case Mood.Angry => "!"
          case Mood.Surprised => "?"
          case Mood.Neutral => ""
      val sep = punc + " "
      words.mkString(sep) + punc
    else
      errmsg

  println(msg)

enum Mood:
  case Surprised, Angry, Neutral

object Mood:
  import scala.util.CommandLineParser.FromString

  given moodFromString: FromString[Mood] with
    def fromString(s: String): Mood =
      s.trim.toLowerCase match
        case "angry" => Mood.Angry
        case "surprised" => Mood.Surprised
        case "neutral" => Mood.Neutral
        case _ => throw new IllegalArgumentException(errmsg)

