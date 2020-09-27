package lab15;

import lombok.SneakyThrows;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Pavel Zeger
 */
public class WordUtils {

    /**
     * The function counts word in a file
     * @param path  Path to a file contains words
     * @param top   Amount of most popular word to return
     * @return      List of most popular words
     */
    @SneakyThrows
    public static List<String> getMostPopularWords(Path path, int top) {
        Map<String, Long> allWords = Files
                .lines(path)
                .flatMap(line -> Arrays.stream(line.trim().split("\\s")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(groupingBy(AbstractMap.SimpleEntry::getKey, counting()));
        return allWords
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(top)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * The function counts word in a file
     * @param file  Path to a file contains words
     * @param top   Amount of most popular word to return
     * @return      List of most popular words
     */
    @SneakyThrows
    public static List<String> getMostPopularWords(File file, int top) {
        ArrayList<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] array = line.split("\\s");
            words.addAll(Arrays.asList(array));
        }
        Map<String, Long> allWords = words
                .stream()
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> word.length() > 0)
                .map(word -> new AbstractMap.SimpleEntry<>(word, 1))
                .collect(groupingBy(AbstractMap.SimpleEntry::getKey, counting()));
        return allWords
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(top)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
