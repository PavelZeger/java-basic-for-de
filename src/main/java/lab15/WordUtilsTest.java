package lab15;

import org.junit.Test;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Zeger
 */
public class WordUtilsTest {

    @Test
    public void getMostPopularWordsTest() {
        Path yesterdayPath = Paths.get("src\\main\\resources\\yesterday");
        File yesterdayFile = new File("src\\main\\resources\\yesterday");
        List<String> popularWordsActualPath = WordUtils.getMostPopularWords(yesterdayPath, 5);
        List<String> popularWordsActualFile = WordUtils.getMostPopularWords(yesterdayFile, 5);
        System.out.println("popularWordsActualPath: ");
        popularWordsActualPath.forEach(System.out::println);
        System.out.println();
        System.out.println("popularWordsActualFile: ");
        popularWordsActualFile.forEach(System.out::println);
        System.out.println();
        assertEquals(popularWordsActualPath.size(), 5);
        assertEquals(popularWordsActualFile.size(), 5);
    }

}