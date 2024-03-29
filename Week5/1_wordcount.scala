// Create a dataset and perform Word Count
val dataset = List("Spark is powerful", "Spark is fast", "Word count with Spark")
val textRDD = sc.parallelize(dataset)

val wordCount = textRDD
  .flatMap(line => line.split(" "))
  .map(word => (word, 1))
  .reduceByKey(_ + _)
  .collect()

wordCount.foreach(println)
