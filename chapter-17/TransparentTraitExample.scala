@main def m(args: String*) =
  val q = new BasicIntQueue with Incrementing with Filtering
  val q2: BasicIntQueue & Incrementing & Filtering =
    new BasicIntQueue with Incrementing with Filtering

trait IntQueue
transparent trait BasicIntQueue extends IntQueue
transparent trait Incrementing extends IntQueue
transparent trait Filtering extends IntQueue


