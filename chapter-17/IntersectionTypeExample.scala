@main def m(args: String*) =
  val q = new BasicIntQueue with Incrementing with Filtering
  val q2: Incrementing & Filtering = q
  val q3: Filtering & Incrementing = q2

trait BasicIntQueue
trait Incrementing
trait Filtering
