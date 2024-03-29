val textData = List("Spark is powerful", "FlatMap transformation in Spark", "Processing text data")
val textRDD = sc.parallelize(textData)

val flatMapResult = textRDD.flatMap(line => line.split(" "))
flatMapResult.collect()
