object S016_MatchCase extends App {
   // in other programming language, switch case
  // in scala, no switch case.. becase switch case is a statement

  // In scala, match case, which is expression, returns output
  val n = 5
  // match case return output
  val result = n match {
    case 0 => "Zero" //return value
    case 1 => "One"
    case _ => "None" // default
  }

  println(result)

  // do match case with data type, conditional if guard
  case class Order(val id: Int, val amount:Double)
  case class RetailOrder(val id: Int, val amount: Double, val tax: Double)

  def processOrder(order: Object) = order match {
    case o: Order => o.amount * 1.18
    // if is called as case guard
    case r: RetailOrder if r.amount >= 10000 => {
      val a = (r.amount * .9) // discount
      a + a * (r.tax/100) // return value
    }
    case r: RetailOrder => r.amount + r.amount * (r.tax/100)
    case _ => 0 // if any new object
  }

  println (  processOrder("hello") ) // 0 default _
  println ( processOrder ( Order(1, 100)) ) // 118 case o: Order
  println ( processOrder(RetailOrder(2, 100, 5))) // 105  case r: RetailOrder
  println (processOrder(RetailOrder(3, 10000, 10))) // 9900



}
