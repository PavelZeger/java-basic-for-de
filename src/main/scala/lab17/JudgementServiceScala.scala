package lab17

import java.io.InputStream
import java.util.Properties
import org.apache.spark.rdd.RDD
import scala.collection.JavaConverters._

/**
 * @author Pavel Zeger
 */
class JudgementServiceScala extends Serializable with SparkConfigurationScala {

  private def getGarbageWords: List[String] = {

    val properties: Properties = new Properties
    val inputStream: InputStream = ClassLoader.getSystemResourceAsStream("user.properties")
    properties.load(inputStream)
    properties
      .getProperty("garbage")
      .split(",")
      .map(word => word.toLowerCase.trim.strip)
      .toList

  }

  def topWords(artistName: String, num: Int): List[String] = {

    val lines: RDD[String] = sparkContext.textFile(s"data/songs/$artistName/*")
    lines
      .map(toLowerCase)
      .flatMap(WordsUtil.getWords(_).asScala)
      .filter(word => !getGarbageWords.contains(word))
      .map(word => Tuple2(word, 1))
      .reduceByKey(_ + _)
      .take(num)
      .map(tuple => tuple._1)
      .toList

  }

  def commonPopularWords(firstArtist: String, secondArtist: String, num: Int): Int = {

    val firstArtistWords: List[String] = topWords(firstArtist, num)
    val secondArtistWords: List[String] = topWords(secondArtist, num)
    firstArtistWords.intersect(secondArtistWords).size

  }

}
