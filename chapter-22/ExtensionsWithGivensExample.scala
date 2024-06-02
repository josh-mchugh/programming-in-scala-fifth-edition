@main def m(args: String*) =
  println("Example of extensions with givens")
  println(s"isort(List(6, 12, -4, 10)): ${isort(List(6, 12, -4, 10))}")

  def isort[T](xs: List[T])(using ord: Ord[T]): List[T] =
    if xs.isEmpty then Nil
    else insert(xs.head, isort(xs.tail))

  def insert[T](x: T, xs: List[T])(using Ord[T]): List[T] =
    if xs.isEmpty || x <= xs.head then x :: xs
    else xs.head :: insert(x, xs.tail)

trait Ord[T]:
  def compare(x: T, y: T): Int
  def lt(x: T, y: T): Boolean = compare(x, y) < 0
  def lteq(x: T, y: T): Boolean = compare(x, y) <= 0
  def gt(x: T, y: T): Boolean = compare(x, y) > 0
  def gteq(x: T, y: T): Boolean = compare(x, y) >= 0

  extension (lhs: T)
    def < (rhs: T): Boolean = lt(lhs, rhs)
    def <= (rhs: T): Boolean = lteq(lhs, rhs)
    def > (rhs: T): Boolean = gt(lhs, rhs)
    def >= (rhs: T): Boolean = gteq(lhs, rhs)

object Ord:
  given Ord[Int] with
    def compare(x: Int, y: Int) =
      if x == y then 0 else if x > y then 1 else -1




