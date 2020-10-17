package lab17;

import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * @author Pavel Zeger
 */
class JudgementServiceTest {

    private JudgementService judgementService = new JudgementService();

    @Test
    void topWordsTest() {

    }

    @Test
    void commonPopularWordsTest() {
        List<String> firstArtistWords = new java.util.ArrayList<>(List.of("first", "second", "third"));
        List<String> secondArtistWords = new java.util.ArrayList<>(List.of("second", "third", "fourth"));
        firstArtistWords.retainAll(secondArtistWords);
        assert firstArtistWords.size() == 2;

    }
}