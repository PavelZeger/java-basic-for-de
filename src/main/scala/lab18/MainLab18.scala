package lab18

/**
 * @author Pavel Zeger
 */
object MainLab18 extends App {

  val garbageWords: List[String] = JudgementServiceScala.getGarbageWordsScala
  val wordsListBritney: List[String] = JudgementServiceScala.topWordsScala("britney", 5, garbageWords)
  val wordsListKetty: List[String] = JudgementServiceScala.topWordsScala("ketty", 5, garbageWords)
  val commonWordsAmount: Int = JudgementServiceScala.commonPopularWords("britney", "ketty", 5, garbageWords)

  println("Common words of Britney:")
  wordsListBritney.foreach(println(_))

  println("Common words of Ketty:")
  wordsListKetty.foreach(println(_))

  println(s"Amount of common words between Britney and Ketty: $commonWordsAmount")

}
