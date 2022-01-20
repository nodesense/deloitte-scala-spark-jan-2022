package workshop.basics

object S010_FunctionN extends  App {

  // Scala has lot of syntatic sugar
  // to keep code more readable
  // Function1, 1 arg, 1 return value
  // internally, scala convert this code into FunctionN format
  val power = (n: Int) => n * n
  // first Int is arg type
  // Last Int is return type
  // Function 1
  val power2:Function[Int, Int] = (n: Int) => n * n

  val powerF = new Function1[Int, Int] {
    def apply(n: Int): Int = n * n
  }

  val add = new Function2[Int, Int, Int] {
    def apply(a: Int, b: Int): Int = a + b
  }

  // internally scala will convert power(5) into power.apply(5)
  println (power(5))
  println(power.apply(5))
  println (powerF(5))
  println(powerF.apply(5))
  println(add(10, 20))
  println(add.apply(10, 20))
}
