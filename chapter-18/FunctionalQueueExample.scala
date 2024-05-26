@main def m(args: String*) =
  println("Functional Queue")
  val que = Queue[Int](1, 2)
  println(s"quque: ${que}")


class SlowAppendQueue[T](elems: List[T]): // Not efficient
  def head = elems.head
  def tail = new SlowAppendQueue(elems.tail)
  def enqueue(x: T) = SlowAppendQueue(elems ::: List(x))

class SlowHeadQueue[T](smele: List[T]): // Not efficient
  //smele is elms reversed
  def head = smele.last
  def tail = new SlowHeadQueue(smele.init)
  def enqueue(x: T) = SlowHeadQueue(x :: smele)

trait Queue[T]:
  def head: T
  def tail: Queue[T]
  def enqueue(x: T): Queue[T]

object Queue:
  def apply[T](xs: T*): Queue[T] =
    new QueueImpl[T](xs.toList, Nil)

  private class QueueImpl[T](
    private val leading: List[T],
    private val trailing: List[T]
  ) extends Queue[T]:
    private def mirror =
      if leading.isEmpty then
        new QueueImpl(trailing.reverse, Nil)
      else
        this

    def head = mirror.leading.head
    def tail =
      val q = mirror
        new QueueImpl(q.leading.tail, q.trailing)

    def enqueue(x: T)=
      new QueueImpl(leading, x :: trailing)

    override def toString = s"head: ${if leading.isEmpty then "empty" else leading}, tail: ${if trailing.isEmpty then "empty" else trailing}"
  end QueueImpl
end Queue

