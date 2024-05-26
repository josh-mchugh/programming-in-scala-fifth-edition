@main def m(args: String*) =
  println("Contravariance")
  Customer.start(Array.empty)

class Publication(val title: String)
class Book(title: String) extends Publication(title)

object Library:
  val books: Set[Book] =
    Set(
      Book("Programming in Scala"),
      Book("Walden")
    )
  def printBookList(info: Book => AnyRef) =
    for book <- books do println(info(book))

object Customer:
  def getTitle(p: Publication): String = p.title
  def start(args: Array[String]): Unit =
    Library.printBookList(getTitle)














