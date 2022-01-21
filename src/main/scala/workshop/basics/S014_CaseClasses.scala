object S014_CaseClasses extends  App {
  // case class
  // case classses special classes, comes with companion object
  // usign case class, we can create object without using new keyword
  // case class members are value type
  // case class for immutable data, to represent a fact, that doesn't change
  // data models using classes

  // id and amount are member variable, of type val [immutable]
  case class Order(id: Int, amount: Double)
  val order1 = new Order(1, 1000)// use of new not needed
  val order2 = Order(2, 200) // this create instance for case class

  println(order1.amount)
  println(order1)

}
