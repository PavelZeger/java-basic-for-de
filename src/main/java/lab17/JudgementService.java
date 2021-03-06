package lab17;

import lombok.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 */
@AllArgsConstructor
@Getter
@Setter
public class JudgementService implements Serializable {

    private final transient SparkConf sparkConfiguration = new SparkConfiguration().developSparkConfiguration();
    private final transient JavaSparkContext sparkContext = new SparkConfiguration().javaSparkContext(sparkConfiguration);

    @SneakyThrows
    public List<String> getGarbageWords() {
        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("user.properties");
        properties.load(inputStream);
        return Arrays
                .stream(properties.getProperty("garbage").split(","))
                .map(word -> word.toLowerCase().trim().strip())
                .collect(Collectors.toList());

    }

    public List<String> topWords(String artistName,
                                 int wordsAmount,
                                 List<String> garbageWords) {
        JavaRDD<String> lines = sparkContext.textFile(String.format("src/main/resources/songs/%s/*", artistName));
        return lines.map(String::toLowerCase)
                .flatMap(WordsUtil::getWords)
                .filter(word -> !garbageWords.contains(word))
                .mapToPair(word -> Tuple2.apply(word, 1))
                .reduceByKey(Integer::sum)
                .take(wordsAmount)
                .stream()
                .map(Tuple2::_1)
                .collect(Collectors.toList());

    }

    public int commonPopularWords(String firstArtist,
                                  String secondArtist,
                                  int wordsAmount,
                                  List<String> garbageWords) {
        ArrayList<String> firstArtistWords = new java.util.ArrayList<>(topWords(
                firstArtist,
                wordsAmount,
                garbageWords));
        ArrayList<String> secondArtistWords = new java.util.ArrayList<>(topWords(
                secondArtist,
                wordsAmount,
                garbageWords));
        firstArtistWords.retainAll(secondArtistWords);
        return firstArtistWords.size();

    }

}