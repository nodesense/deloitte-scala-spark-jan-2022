package workshop.basics

object S011_FunctionMethods extends  App {

  def pow(n: Int) = n * n // method
  val power = (n: Int) => n * n // function

  // convert method into function using _
  // p is function that wrap pow method
  val p = pow _ // convert method into function

  println ( p(5) )
  println (p.apply(5))

  println (pow(5))
  // error , since pow is not function
 // println(pow.apply(5))


}
