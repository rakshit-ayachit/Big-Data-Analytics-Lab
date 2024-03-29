// Load the data into a PySpark DataFrame
val df = spark.read
  .option("header", "true")
  .option("inferSchema", "true")
  .csv("consumer.csv")

// Replace the string in column Cardtype from Checking to Cash using na.replace
val replacedDF = df.na.replace("Card_type", Map("Checking" -> "Cash"))

// Replace the string in column Cardtype from Checking to Cash using regexp_replace
import org.apache.spark.sql.functions.regexp_replace
val updatedDF = df.withColumn("Card_type", regexp_replace(col("Card_type"), "Checking", "Cash"))

// Show the DataFrame after replacing the string
replacedDF.show()
updatedDF.show()

