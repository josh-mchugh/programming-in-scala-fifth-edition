import scala.collection.mutable.ArrayBuffer

@main def m(args: String*) =
  val queue = new BasicIntQueue
  queue.put(10)
  queue.put(20)
  println(s"Queue get 1: ${queue.get()}")
  println(s"Queue get 2: ${queue.get()}")

  val myQueue = new MyQueue
  myQueue.put(10)
  println(s"MyQueue get 1: ${myQueue.get()}")

  val doubleQueue = new BasicIntQueue with Doubling
  doubleQueue.put(10)
  println(s"DoubleQueue get 1: ${doubleQueue.get()}")

  val incFilterQueue = new BasicIntQueue with Incrementing with Filtering
  incFilterQueue.put(-1)
  incFilterQueue.put(0)
  incFilterQueue.put(1)
  println(s"Inc Filter Queue get 1: ${incFilterQueue.get()}")
  println(s"Inc Filter Queue get 2: ${incFilterQueue.get()}")

  val filterIncQueue = new BasicIntQueue with Filtering with Incrementing
  filterIncQueue.put(-1)
  filterIncQueue.put(0)
  filterIncQueue.put(1)
  println(s"Filter Inc Queue get 1: ${filterIncQueue.get()}")
  println(s"Filter Inc Queue get 2: ${filterIncQueue.get()}")
  println(s"Filter Inc Queue get 3: ${filterIncQueue.get()}")

abstract class IntQueue:
  def get(): Int
  def put(x: Int): Unit

class BasicIntQueue extends IntQueue:
  private val buf = ArrayBuffer.empty[Int]
  def get() = buf.remove(0)
  def put(x: Int) = buf += x

trait Doubling extends IntQueue:
  abstract override def put(x: Int) = super.put(2 * x)

trait Incrementing extends IntQueue:
  abstract override def put(x: Int) = super.put(x + 1)

trait Filtering extends IntQueue:
  abstract override def put(x: Int) = if x >= 0 then super.put(x)

class MyQueue extends BasicIntQueue, Doubling
