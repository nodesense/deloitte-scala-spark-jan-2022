package workshop.basics

object S007_MethodDefaultArgs extends App {
  def sum(a: Int, b: Int, c: Int = 0) = a + b + c

  println ( sum (10, 20, 30) ) // a = 10, b = 20, c = 30
  println ( sum (10, 20) ) // a = 10, b = 20, c = 0 [default]
}
