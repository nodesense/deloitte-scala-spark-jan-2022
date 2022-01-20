package workshop.basics

object S002_VarVal extends App {

  // variable, value can be changed
  // try to avoid using var
  var i: Int = 0
  i = 100
  // immutable/constant, can't be changed
  val PI:Double = 3.14
  // error
  // PI = 2.14

  // type inference
  // scala variable can be declared with type if not, scala derie the type from expression
  // name is String type, scala scan your code in assignement opeartor
  // driver the type
  // type inference
  val name = "Scala"

  val k = 10

}
