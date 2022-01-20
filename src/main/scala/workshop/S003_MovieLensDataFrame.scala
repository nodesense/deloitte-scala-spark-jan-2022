package workshop

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
// import one
import org.apache.spark.sql.functions.upper
// import many
import org.apache.spark.sql.functions.{upper, lower, trim}
// import all  _ all
import org.apache.spark.sql.functions._

object S003_MovieLensDataFrame extends  App {
  val spark: SparkSession  = SparkSession
    .builder()
    .master("local") // spark run inside hello world app
    .appName("HelloWorld")
    .getOrCreate()
  // RDD
  val sc: SparkContext = spark.sparkContext
  sc.setLogLevel("WARN")

  import spark.implicits._

  val movieDf = spark.read
                     .format("csv")
                    .option("header", true)
                    .option("delimitter", ",")
                    .option("inferSchema", true)
                    .load("C:\\Apche-Spark3-Workshop\\input\\movies.csv")

  movieDf.printSchema()
  movieDf.show(truncate = false)

  // behind every dataframe,  there is RDD
  // movieDf.rdd.getNumPartitions
  // to get schema object of data frame
  val schema = movieDf.schema
  println(schema)

  // return new data frame with new schema
  val df3 = movieDf.select("movieId", "title")
                    .withColumnRenamed("title", "name")
    .withColumn("name_uppercase", upper( col("name") ))
    .drop("name")
  df3.printSchema()
  df3.show(2)
}
