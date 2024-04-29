@main def m(args: String*) =
  val acc = new ChecksumAccumulator
  acc.add(3)
  val csa = new ChecksumAccumulator

  println(s"acc: ${acc.checksum()}")
  println(s"csa: ${csa.checksum()}")

class ChecksumAccumulator:
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1
