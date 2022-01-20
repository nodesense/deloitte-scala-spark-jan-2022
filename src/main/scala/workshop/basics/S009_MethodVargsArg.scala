package workshop.basics

object S009_MethodVargsArg extends  App {

  // variable number of arguments
  def printAll(names: String*) = {
    println(names)
    names.foreach(println)
  }

  def sumAll (numbers: Int*) = {
    var s = 0
    for (n <- numbers) s += n

    s // return s
  }

  printAll () // no arg, print nothing
  printAll("Scala") // 1 arg, print scala
  printAll("Scala", "Spark", "DAta Bricsk") // 3 args

  println (   sumAll ()   )  // returns 0, no arg
  println ( sumAll(10, 20) ) // 2 args, returns 30

}
