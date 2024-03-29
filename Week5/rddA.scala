    // Read the text file into an RDD
    val externalRDD = sc.textFile("input_rdd.txt")
    
    // Sort by key
    val sortedRDD = externalRDD.map(line => (line.split(",")(0).toInt, line))
      .sortByKey()
      .collect()
    
    println("Sorted RDD:")
    sortedRDD.foreach(println)
    
    // Group by key
    val groupedByKey = externalRDD.map(line => (line.split(",")(0), line))
      .groupByKey()
      .collect()
    
    println("\nGrouped by key:")
    groupedByKey.foreach(println)
    
    // Count by key
    val countByKey = externalRDD.map(line => (line.split(",")(0), 1))
      .countByKey()
    
    println("\nCount by key:")
    countByKey.foreach(println)
