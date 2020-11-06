package lab18

import java.io.InputStream
import java.util.Properties
import lab17.WordsUtil
import org.apache.spark.rdd.RDD
import scala.collection.JavaConverters._

/**
 * @author Pavel Zeger
 */
object JudgementServiceScala extends Serializable with SparkConfigurationScala {

  def getGarbageWordsScala: List[String] = {

    val properties: Properties = new Properties
    val inputStream: InputStream = ClassLoader.getSystemResourceAsStream("user.properties")
    properties.load(inputStream)
    properties
      .getProperty("garbage")
      .split(",")
      .map(_.toLowerCase.trim.strip)
      .toList

  }

  def topWordsScala(artistName: String,
                    wordsAmount: Int,
                    garbageWords: List[String]): List[String] = {

    val lines: RDD[String] = sparkContext.textFile(s"src/main/resources/songs/$artistName/*")
    lines
      .map(_.toLowerCase)
      .flatMap(WordsUtil.getWords(_).asScala)
      .filter(word => !garbageWords.contains(word))
      .map(Tuple2(_, 1))
      .reduceByKey(_ + _)
      .take(wordsAmount)
      .map(_._1)
      .toList

  }

  def commonPopularWords(firstArtist: String,
                         secondArtist: String,
                         wordsAmount: Int,
                         garbageWords: List[String]): Int = {

    val firstArtistWords: List[String] = topWordsScala(firstArtist, wordsAmount, garbageWords)
    val secondArtistWords: List[String] = topWordsScala(secondArtist, wordsAmount, garbageWords)
    firstArtistWords.intersect(secondArtistWords).size

  }

}
