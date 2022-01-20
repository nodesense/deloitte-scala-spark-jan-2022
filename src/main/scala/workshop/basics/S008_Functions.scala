package workshop.basics

object S008_Functions extends  App {

  // Def - method, equvalant of Java member function, method is not object
  // method should have name

  // functions - lambdas in Java 8
  // annonymouse function, no need to have name
  // functions - are objects, first class citizen
  // if functions are objects, we can pass function as arg, assigne to variable,
  //    return a function as output

  // power is variable referencing an annoymous function
  //  (declartion for arg) => function body
  // Function1 - 1 arg, return Int
  val power = (n: Int) => n * n
  // Function2 , 2 args, return Int
  val add = (a: Int, b: Int) => a + b
  val mul = (a: Int, b: Int) => {
    // multi line
    a * b
  }

  // assign function to variable

  def div(a : Int, b: Int) = a / b



  println (power (5) )
  println( add(10, 20) )
  println (mul (10, 20) )

}
