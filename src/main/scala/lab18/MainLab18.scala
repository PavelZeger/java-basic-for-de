package lab18

/**
 * @author Pavel Zeger
 */
object MainLab18 extends App {

  val wordsListBritney: List[String] = JudgementServiceScala.topWordsScala("britney", 5)
  val wordsListKetty: List[String] = JudgementServiceScala.topWordsScala("ketty", 5)
  val commonWordsAmountBritneyAndKetty: Int = JudgementServiceScala.commonPopularWords("britney", "ketty", 5)

  println("Common words of Britney:")
  wordsListBritney.foreach(println(_))

  println("Common words of Ketty:")
  wordsListKetty.foreach(println(_))

  println(s"Amount of common words between Britney and Ketty: $commonWordsAmountBritneyAndKetty")

}
