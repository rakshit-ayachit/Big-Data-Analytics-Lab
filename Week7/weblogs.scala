// Load the data into a PySpark DataFrame
val df = spark.read
  .option("header","true")
  .option("inferSchema", "true")
  .csv("web_logs.txt")
  .toDF("Timestamp", "user_id", "page_id", "action")

// Identify the most engaged users by calculating the total time spent on the website for each user
import org.apache.spark.sql.functions._

val totalTimeDF = df.groupBy("user_id")
  .agg(sum(when(col("action") === "view", 1).otherwise(0)).alias("total_time_spent"))

totalTimeDF.show()

