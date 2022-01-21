object S012_Classes extends App {

  // classes a prototype to create objects
  // classes, access specifier [private/public, protected], inheritance

  // 2. The constructor arguments or member variables can be mentioned part of class declartion
  // var/val in class name declaration, - they are member variables
  // without var/val, they are constructor args
  // id and name are member variable of public access specificer, p is constructor arg
  class Product (val id: Int, val name: String, p: Double) {
    // 1.  in scala, with in class, or class body, the brace/block is called default constructor
    // in python with __init__
    // Java you create constructor with class name

    // member variable can be declard here too
    val price = p // price is member variable
    var discount: Double = 0 //variable can be changed

    // member functions

    def getPrice() = price
    def getDiscount() = discount
    def setDiscount(value: Double) = discount = value

    println("Product created", id, name, p)
  }

  // p1 is instance/object of class Product
  val p1 = new Product(1, "iPHone", 50000) //calls constructor class body
  val p2 = new Product(2, "Galaxy", 35000)

  // public member variable can be accessible outside class
  println("p1 ", p1.id, p1.name) // can't get p1.p it is not member
  println("p2", p2.id, p2.name)

  println("p1 price discount", p1.price, p1.discount)

  p1.setDiscount(5)
  println("p1 discount ", p1.getDiscount())

}
