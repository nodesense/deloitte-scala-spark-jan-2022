package workshop


import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DoubleType, IntegerType, LongType, StringType, StructField, StructType}
import  org.apache.spark.sql.functions._

object S007_MovieLensAnalytics extends  App {
  val MoviesPath = "C:\\Apche-Spark3-Workshop\\input\\movies.csv"
  val RatingsPath = "C:\\Apche-Spark3-Workshop\\input\\ratings.csv"

  val spark: SparkSession  = SparkSession
    .builder()
    .master("local") // spark run inside hello world app
    //.master("spark://192.168.1.103:7077") // now driver runs the tasks on cluster
    .appName("MovieLensAnalytics")
    // .config("spark.cores.max", "48") // MAX CORE Across Cluster
   // .config("spark.executor.memory", "4g")
    .getOrCreate()

  spark.sparkContext.setLogLevel("WARN")

  import spark.implicits._
  // movie schema
  val MovieSchema = StructType(
    List(
      StructField("movieId", IntegerType, true), // true means nullable
      StructField("title", StringType, true),
      StructField("genres", StringType, true)
    )
  )

  val RatingSchema = StructType(
    List(
      StructField("userId", IntegerType, true),
      StructField("movieId", IntegerType, true),
      StructField("rating", DoubleType, true),
      StructField("timestamp", LongType, true)
    )
  )


  // we no need to use inferSchema
  val movieDf = spark.read
    .format("csv")
    .option("header",  true)
    .option("delimitter", ",")
    .schema(MovieSchema) // use the Schema
    .load(MoviesPath)

  // we no need to use inferSchema
  val ratingDf = spark.read
    .format("csv")
    .option("header",  true)
    .option("delimitter", ",")
    .schema(RatingSchema) // use the Schema
    .load(RatingsPath)


  movieDf.printSchema()
  ratingDf.printSchema()

  movieDf.show(5)
  ratingDf.show(5)


  // $- scala special feature
  // in spark, $ here means col $"rating" == col("rating")
  val ratingsAbove4Df = ratingDf.filter ($"rating" >= 4)
  ratingsAbove4Df.show(10)

  ratingDf.select("rating").distinct().show()

  // asc
  ratingDf.select("rating").distinct().sort(col("rating")).show()

  // desc
  ratingDf.select("rating").distinct().sort(desc("rating")).show()


  // just for demo/throw away
  movieDf.withColumn("imdb", lit(4) ).show(5)


  // concat to concat columns
  // just for demo/throw away
  movieDf.withColumn("description",
    concat(
      col("title"),
      lit (" is categorized as "),
      col("genres") )
  )
    .show(10)

  val popularMovies = ratingDf
    .groupBy($"movieId")
    .agg(avg("rating").alias("avg_rating"), count("userId"))
    .withColumnRenamed("count(userId)", "total_rating")
    .filter( ($"total_rating" >= 100 ) && ($"avg_rating" >= 3 ))
    .sort(desc("avg_rating"))


  popularMovies.printSchema()
  popularMovies.show(200)

  val slimMovieDf = movieDf.select("movieId", "title")

  // the data is readily avaialbel in all the workers where executors running
  // all small tables, master/dimension tables can be broadcasted
  val broadcatedMovieDf = broadcast(slimMovieDf)
  // spark scala, for filters, joins etc you should use ===, !== because these are overload opeartors
  val mostPopularMoviesList = popularMovies.join(broadcatedMovieDf, popularMovies("movieId") === movieDf("movieId"))
    .select(popularMovies("movieId"), $"title", $"avg_rating", $"total_rating" )

  mostPopularMoviesList.printSchema()
  mostPopularMoviesList.show()

}
