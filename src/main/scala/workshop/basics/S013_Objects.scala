object S013_Objects extends  App {

  // what is object in scala
  // in Java Terminology, Object is something similar to static class
  // use without creating instance
  // object itself is an intance
  // object is singleton in Scala, only 1 instance

  object Logger {
    // object constructor
    // initializing object first time on first use
    println("Logger...")

    var logLevel : String = "Debug"
    // member function for object
    def setLogLevel(l: String) = logLevel = l
    // implement info, warn, error etc here
    // member variables var/val
    // member functions
  }

  Logger // it will call object conscturoe first time only
   Logger.setLogLevel("Error")
  // we cannot create instance for object, because object is not prototype
}
