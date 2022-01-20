package workshop.basics

object S003_Methods extends  App {
  // method are reusable code
  // Methods are not LAMBDA
  // add function, takes 2 parameters a, b, returns a + b as int
  def add(a: Int, b: Int): Int = a + b
  // return type is inferred from expression a - b (Int)
  def sub(a: Int, b: Int) =  a - b
  def mul(a:Int, b:Int) = {
    // block expression
    // multi line statement/expressions
    println(a, b)
    // return a * b
    // the last executed expression values are returned
    a * b // no need to use return keyword
  }

  println (add (10, 20))
  println (sub (10, 20))
  println (mul (10, 20))
}
