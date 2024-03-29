val studentData = List(("Alice", "Math", 90), ("Bob", "Math", 85), ("Alice", "Physics", 88), ...)
val studentRDD = sc.parallelize(studentData)

val groupedBySubject = studentRDD.groupBy(record => record._2)
groupedBySubject.collect()
