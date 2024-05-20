@main def m(args: String*) =
  val account = new BankAccount
  account.deposit(100)
  println(s"withdraw 80: ${account.withdraw(80)}")
  println(s"withdraw 80: ${account.withdraw(80)}")

class BankAccount:
  private var bal: Int = 0
  def balance: Int = bal
  def deposit(amount: Int): Unit =
   require(amount > 0)
   bal += amount
  def withdraw(amount: Int): Boolean =
    if amount > bal then false
    else
      bal -= amount
      true

