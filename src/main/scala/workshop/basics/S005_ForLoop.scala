package workshop.basics

object S005_ForLoop extends  App {
  // ForLoops are internally called iterators
  // In Scala, we have primitives - Boolean, Int, Short, Long, Double, .....
  // at compile time, scala treats primitive as classes/instances/objects
  // At runtime, JVM, primitives are java native primitives

  val i = 10

  // here + is a method, i  is instance of class Int
  println ( i + 2)
  // same as above
  println ( i.+(2) )


  // generate a seq
  println ( 1 to 10)
  println ( 1 until 10)
  println( 1.to(10))
  // <- 1 to 10
  for (i <- 1 to 10)
    println(i)


  // {} - expression, return output

  val result = {
    val a: Int = 10
    val b : Int = 20
    a + b // return
  }

  println("Result " + result)

}
