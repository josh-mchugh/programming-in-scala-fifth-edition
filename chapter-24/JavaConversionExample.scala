import scala.jdk.CollectionConverters.*
import collection.mutable.*

@main def m(args: String*) =
  println("Java Conversion Example")
  val jul: java.util.List[Int] = ArrayBuffer(1, 2, 3).asJava
  println(s"jul: $jul")
  val buf: Seq[Int] = jul.asScala
  println(s"buf: $buf")
  val m: java.util.Map[String, Int] = HashMap("abc" -> 1, "hello" -> 2).asJava
  println(s"m: $m")



