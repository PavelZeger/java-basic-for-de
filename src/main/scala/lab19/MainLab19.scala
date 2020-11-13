package lab19

import lab18.SparkConfigurationScala
import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.StructField

/**
 * @author Pavel Zeger
 */
object MainLab19 extends App with SparkConfigurationScala {

  private val ageColumnName: String = "age"
  private val birthdayColumnName: String = "birthday"
  private val salaryColumnName: String = "salary"
  private val keywordsColumnName: String = "keywords"
  private val keywordColumnName: String = "keyword"
  private val amountColumnName: String = "amount"

  val rawDataframe: DataFrame = sqlContext.read.json("src/main/resources/profiles.json")
  val rawDataframeFields: Array[StructField] = rawDataframe.schema.fields

  val birthdayYearDataframe: DataFrame = rawDataframe
    .withColumn(birthdayColumnName, year(expr(s"date_sub(current_date(), $ageColumnName * 365)")))

  val salaryDataFrame: DataFrame = birthdayYearDataframe
    .withColumn(salaryColumnName, col(ageColumnName)
    .multiply(100)
    .multiply(size(col(keywordsColumnName))))

  val keywordDataframe: DataFrame = salaryDataFrame
    .select(explode(col(keywordsColumnName)).alias(keywordColumnName))

  val row: Row = keywordDataframe
    .groupBy(col(keywordColumnName))
    .agg(count(keywordColumnName)
      .as(amountColumnName))
    .sort(col(amountColumnName)
      .desc)
    .head

  val mostPopularSkill: String = row.getAs(keywordColumnName)

  val filteredSalaryDataframe: DataFrame = salaryDataFrame
    .filter(array_contains(col(keywordsColumnName), mostPopularSkill))
    .filter(col(salaryColumnName).leq(20000))

  birthdayYearDataframe.show()
  birthdayYearDataframe.printSchema()
  rawDataframeFields.foreach(println(_))
  keywordDataframe.show()
  salaryDataFrame.show()
  println(s"The most popular skill is: $mostPopularSkill")
  filteredSalaryDataframe.show()

}
