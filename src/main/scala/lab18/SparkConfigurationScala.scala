package lab18

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
 * @author Pavel Zeger
 */
trait SparkConfigurationScala {

  lazy val sparkConf: SparkConf = new SparkConf()
    .setMaster("local[*]")
    .setAppName("DevelopApp")

  lazy val sparkContext: SparkContext = SparkContext.getOrCreate(sparkConf)

}
