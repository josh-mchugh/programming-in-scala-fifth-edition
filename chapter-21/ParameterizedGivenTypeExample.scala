@main def m(args: String*) =
  println("Parameterized Given Types")
  println(s"sort Int: ${isort(List(4, -10, 10))}")
  println(s"sort String: ${isort(List("cherry", "blackberry", "apple", "pear"))}")

def isort[T](xs: List[T])(using ord: Ord[T]): List[T] =
  if xs.isEmpty then Nil
  else insert(xs.head, isort(xs.tail))

def insert[T](x: T, xs: List[T])(using ord: Ord[T]): List[T] =
  if xs.isEmpty || ord.lteq(x, xs.head) then x :: xs
  else xs.head :: insert(x, xs.tail)

trait Ord[T]:
  def compare(x: T, y: T): Int
  def lteq(x: T, y: T): Boolean = compare(x, y) < 1

object Ord:
  given intOrd: Ord[Int] with
    def compare(x: Int, y: Int) =
      if x == y then 0 else if x > y then 1 else -1

  given stringOrd: Ord[String] with
    def compare(s: String, t: String) = s.compareTo(t)
