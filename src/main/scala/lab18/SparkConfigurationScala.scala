package lab18

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

/**
 * @author Pavel Zeger
 */
trait SparkConfigurationScala {

  lazy val sparkConf: SparkConf = new SparkConf()
    .setMaster("local[*]")
    .setAppName("DevelopApp")

  lazy val sparkContext: SparkContext = SparkContext.getOrCreate(sparkConf)

  lazy val sqlContext: SQLContext = SQLContext.getOrCreate(sparkContext)

}
