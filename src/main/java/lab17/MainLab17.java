package lab17;

import java.util.List;

/**
 * @author Pavel Zeger
 */
public class MainLab17 {

    public static void main(String[] args) {

        JudgementService judgementService = new JudgementService();
        List<String> garbageWords = judgementService.getGarbageWords();
        List<String> wordsListBritney = judgementService.topWords("britney", 5, garbageWords);
        List<String> wordsListKetty = judgementService.topWords("ketty", 5, garbageWords);
        int commonWordsAmount = judgementService.commonPopularWords("britney", "ketty", 5, garbageWords);

        System.out.println("Common words of Britney:");
        wordsListBritney.forEach(System.out::println);
        System.out.println("Common words of Ketty:");
        wordsListKetty.forEach(System.out::println);

        System.out.printf("Amount of common words between Britney and Ketty: %s%n", commonWordsAmount);

    }

}
