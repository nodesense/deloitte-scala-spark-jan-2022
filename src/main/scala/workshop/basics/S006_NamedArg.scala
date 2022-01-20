package workshop.basics

object S006_NamedArg extends App {
  def sum (a: Int, b: Int, c: Int) = a + b + c

  // how to call function, pass arg using arg name
  // left to right
  println (  sum(10, 20, 30)   ) // a = 10, b = 20, c = 30
  // name the arg
  println (  sum ( 10, b= 20, c = 30)   )
}
