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
// Parallelized collection
val arrayRDD = sc.parallelize(Array(1, 2, 3, 4, 5))

// Existing RDD and finding sum
val sum = arrayRDD.reduce(_ + _)

// RDD from external sources
val externalRDD = sc.textFile("hdfs://your-hdfs-path/external/data.txt")

// DataFrame Creation for Employee Data
import org.apache.spark.sql.{SparkSession, Row}
import org.apache.spark.sql.types._

val spark = SparkSession.builder.appName("EmployeeData").getOrCreate()

val schema = StructType(Seq(
  StructField("RegNo", IntegerType, nullable = false),
  StructField("EmpName", StringType, nullable = false),
  StructField("Age", IntegerType, nullable = false),
  StructField("Salary", IntegerType, nullable = false)
))

val employeeDF = spark.createDataFrame(
  employeeRDD.map(record => Row(record._1, record._2, record._3, record._4)),
  schema
)

employeeDF.show()
