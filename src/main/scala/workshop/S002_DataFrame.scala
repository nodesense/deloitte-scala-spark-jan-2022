package workshop

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object S002_DataFrame extends App {
  val spark: SparkSession  = SparkSession
    .builder()
    .master("local") // spark run inside hello world app
    .appName("DataFrame")
    .getOrCreate()

  // underscore means import all
  import spark.implicits._
  // RDD
  val sc: SparkContext = spark.sparkContext
  sc.setLogLevel("WARN") // WAIN, ERROR shall be displayed


    // Case Class
  case class User(id: Int, name: String)

  val user1 = User(1, "Joe")

  // create RDD of users
  val users = sc.parallelize( List (
      User(1, "Joe"),
    User(2, "Senthil"),
    User(3, "Venkat")
  ) )

  // convert rdd into dataframe
  val usersDf = users.toDF()

  usersDf.show(false)

  usersDf.printSchema()

  // Filter data, every data frame manipulation will create new data frame
  // data frame is immutable
  val df2 = usersDf.filter("id = 3")
  df2.show() // Venkat

  //SQL temp table
  usersDf.createOrReplaceTempView("users")

  val df3 = spark.sql("Select name from users where id = 3")
  df3.show()
  df3.printSchema()

}
