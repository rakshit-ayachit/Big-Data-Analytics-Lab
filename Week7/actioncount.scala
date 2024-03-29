// Load the data into a PySpark DataFrame
val df = spark.read
  .option("header", "true")
  .csv("clickstream_data.csv")

// Display schema and the first 5 rows of the DataFrame
df.printSchema()
df.show(5)

// Calculate the total number of clicks, views, and purchases for each user
val actionsCount = df.groupBy("user_id", "action")
  .count()

actionsCount.show()

// Identify the most common sequence of actions performed by users
import org.apache.spark.sql.functions.collect_list

val sequenceDF = df.groupBy("user_id")
  .agg(collect_list("action").alias("action_sequence"))

sequenceDF.show()
