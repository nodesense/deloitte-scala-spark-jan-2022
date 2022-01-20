package workshop.basics

object S004_IfExpr extends  App {
   // Statement - all lines are statements
  // In Java, C++ etc, for is loop, if , switch case statement doesn't return values
  // Expressions - computation, function calls etc, has output, returns value

  // in scala, if else is expression, not statement
  // if statement shall return output
  // "Even" returnede if troe else "Odd"
  val result = if (10 % 2 == 0) "Even" else "Odd"
  println(result)
}
