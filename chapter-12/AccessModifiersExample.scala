@main def m(args: String*) =
  println("Access Modifiers")

// Example of private members
class Outer:

  class Inner:
    private def f = "f"
    class InnerMost:
      f

  // line below fails compile because variable is private in Inner
  //(new Inner).f

// Example of protected members
package p:

  class Super:
    protected def f = "f"
  class Sub extends Super:
    f

  // line below fails compile because variable is protected and only accessible
  // from sub classes
  //class Other:
  //  (new Super).f

// Example of public members
package bobsrockets:
  package navigation:
    private[bobsrockets] class Navigator:
      protected[navigation] def useStarChart() = {}
      class LegOfJourney:
        private[Navigator] val distance = 100
  package launch:
    import navigation.*
    object Vehicle:
      private[launch] val guide = new Navigator
