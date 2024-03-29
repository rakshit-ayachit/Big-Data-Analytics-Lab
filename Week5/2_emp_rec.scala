// Create RDD from the employee dataset and apply map transformation
val employeeData = List(
  (24, "John", 26, 30000),
  (34, "Jack", 40, 80000),
  (61, "Joshi", 25, 35000),
  (45, "Jash", 35, 75000),
  (34, "Yash", 40, 60000),
  (67, "Smith", 20, 24000),
  (42, "Lion", 42, 56000),
  (62, "Kate", 50, 76000),
  (21, "Cassy", 51, 40000),
  (10, "Ronald", 57, 65000),
  (24, "John", 26, 30000),
  (67, "Smith", 20, 24000),
  (45, "Jash", 35, 75000),
  (21, "Cassy", 51, 40000)
)

val employeeRDD = sc.parallelize(employeeData)

val transformedRDD = employeeRDD.map(record => (record._1, record._2, record._3 * 2, record._4))
transformedRDD.collect()
