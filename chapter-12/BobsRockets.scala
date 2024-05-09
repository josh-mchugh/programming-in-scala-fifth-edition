@main def m(args: String*) =
  println("Bobs Rockets!!")

package bobsrockets:
  package navigation:
    // In package bobsrockets.navigation
    class Navigator:
      // No need to say bobsrockets.navigation.StarMap
      val map = new StarMap

    class StarMap
  class Ship:
    // No need to say bobsrockets.navigation.Navigator
    val nav = new navigation.Navigator
  package fleets:
    // In package bobsrockets.fleets
    class Fleet:
      // No need to say bobsrockets.Ship
      def addShip = new Ship

// In the file launch.scala
package launch:
  class Booster3

package bobsrockets:
  package launch:
    class Booster2
  package navigation:
    package launch:
      class Booster1

    class MissionControl:
      val booster1 = new launch.Booster1
      val booster2 = new bobsrockets.launch.Booster2
      val booster3 = new _root_.launch.Booster3
