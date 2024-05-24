@main def main(args: String*) =
  val money = new Dollars(1_000_000)
  println(s"money: $money")
  val html = title(Text("Value Classes"), Anchor("chap:vcls"), Style("bold"))
  println(s"title: ${html.value}")

class Dollars(val amount: Int) extends AnyVal:
  override def toString = "$" + amount

class SwissFrancs(val amount: Int) extends AnyVal:
  override def toString = s"$amount CHF"

class Anchor(val value: String) extends AnyVal
class Style(val value: String) extends AnyVal
class Text(val value: String) extends AnyVal
class Html(val value: String) extends AnyVal

def title(text: Text, anchor: Anchor, style: Style): Html =
  Html(
    s"<a id='${anchor.value}'>" +
      s"<h1 class='${style.value}'>" +
      text.value +
      s"</h1>" +
    s"</a>"
  )
