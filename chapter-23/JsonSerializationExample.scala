import ToJsonMethods.*

@main def m(args: String*) =
  println("JSON Serialization Example")
  println("tennis".toJson)
  println(10.toJson)
  println(true.toJson)
  println(addressBook.toJson)

trait JsonSerializer[T]:
  def serialize(o: T): String
  extension (a: T)
    def toJson: String = serialize(a)

object JsonSerializer:
  given stringSerializer: JsonSerializer[String] with
    def serialize(s: String) = s"\"$s\""

  given intSerializer: JsonSerializer[Int] with
    def serialize(n: Int) = n.toString

  given longSerializer: JsonSerializer[Long] with
    def serialize(n: Long) = n.toString

  given booleanSerializer: JsonSerializer[Boolean] with
    def serialize(b: Boolean) = b.toString

  given listSerializer[T](using JsonSerializer[T]): JsonSerializer[List[T]] with
    def serialize(ts: List[T]) = s"[${ts.map(t => t.toJson).mkString(", ")}]"

object ToJsonMethods:
  extension [T](a: T)(using jser: JsonSerializer[T])
    def toJson: String = jser.serialize(a)

case class Address(
  street: String,
  city: String,
  state: String,
  zip: Int
)

object Address:
  given addressSerializer: JsonSerializer[Address] with
    def serialize(a: Address) =
      import ToJsonMethods.{toJson as asJson}
      s"""|{
          |  "street": ${a.street.asJson},
          |  "city": ${a.city.asJson},
          |  "state": ${a.state.asJson},
          |  "zip": ${a.zip.asJson}
          |}""".stripMargin

case class Phone(
  countryCode: Int,
  phoneNumber: Long
)

object Phone:
  given phoneSerializer: JsonSerializer[Phone] with
    def serialize(p: Phone) =
      import ToJsonMethods.{toJson as asJson}
      s"""|{
          |  "countryCode": ${p.countryCode.asJson},
          |  "phoneNumber": ${p.phoneNumber.asJson}
          |}""".stripMargin

case class Contact(
  name: String,
  addresses: List[Address],
  phones: List[Phone]
)

object Contact:
  given contactSerializer: JsonSerializer[Contact] with
    def serialize(c: Contact) =
      import ToJsonMethods.{toJson as asJson}
      s"""|{
          |  "name": ${c.name.asJson},
          |  "addresses: ${c.addresses.asJson},
          |  "phones": ${c.phones.asJson}
          |}""".stripMargin

case class AddressBook(contacts: List[Contact])

object AddressBook:
  given addressBookSerializer: JsonSerializer[AddressBook] with
    def serialize(a: AddressBook) =
      import ToJsonMethods.{toJson as asJson}
      s"""|{
          |  "contacts": ${a.contacts.asJson}
          |}""".stripMargin

val addressBook =
  AddressBook(
    List(
      Contact(
        "Bob Smith",
        List(
          Address(
            "12345 Main Street",
            "San Francisco",
            "CA",
            94105
          ),
          Address(
            "500 State Street",
            "Los Angeles",
            "CA",
            90007
          )
        ),
        List(
          Phone(
            1,
            5558413323
          ),
          Phone(
            49,
            5558413323
          )
        )
      )
    )
  )





