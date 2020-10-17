package lab17;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * @author Pavel Zeger
 */
@Getter
@Setter
@AllArgsConstructor
public class SparkConfiguration {

    public SparkConf developSparkConfiguration() {
        return new SparkConf()
                .setMaster("local[*]")
                .setAppName("DevelopApp");
    }

    public JavaSparkContext javaSparkContext(SparkConf sparkConf) {
        return new JavaSparkContext(sparkConf);
    }

}
