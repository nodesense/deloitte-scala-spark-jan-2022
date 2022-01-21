object S015_CompanionObject extends  App {
  // companion object
  // in the same file, when have class   and object with same name, known as companion class
  // This is useful to create object without using new keyword
  // this makes object creation more of functional rather than statement
  // destructuring extract attributes from object
  // companion object known as object factory/object builder
  class Product(val id: Int, val price: Double) {
    println("PRoduct created")
  }

  object Product {
    def apply(): Product = new Product(0, 0)
    def apply(id: Int, price: Double) = new Product(id, price)
  }

  val p1 = Product() // internally this invoke Product.apply
  val p2 = Product(100, 10000.34)

}
