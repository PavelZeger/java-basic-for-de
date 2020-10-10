package lab16;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

/**
 * @author Pavel Zeger
 */
public class TaxiService {
    public static void main(String[] args) {
        SparkConf sparkConfiguration = new SparkConfiguration().developSparkConfiguration();
        JavaSparkContext sparkContext = new SparkConfiguration().javaSparkContext(sparkConfiguration);
        JavaRDD<String> orders = sparkContext.textFile("src\\main\\resources\\taxi_orders.txt", 1);
        JavaRDD<String> drivers = sparkContext.textFile("src\\main\\resources\\drivers.txt", 1);

        Long numberOfRows = orders.count();

        Long numberOfTrips = orders
                .filter(row -> row.toLowerCase().contains("boston"))
                .filter(row -> Integer.parseInt(row.split("\\s")[2]) > 10)
                .count();

        Integer sumOfKms = orders
                .filter(row -> row.toLowerCase().contains("boston"))
                .map(row -> Integer.parseInt(row.split("\\s")[2]))
                .reduce(Integer::sum);

        System.out.format("Number of lines in `taxi_orders.txt`: %d\n", numberOfRows);
        System.out.format("Number of trips to Boston longer than 10 km: %d\n", numberOfTrips);
        System.out.printf("Amount of all trips to Boston in kilometers: %d\n", sumOfKms);

        //Write names of 3 drivers with max total kilometers in this day(sort top to down)
        orders.mapToPair(row -> new Tuple2<>(row.split("\\s")[0], Integer.parseInt(row.split("\\s")[2])))
                .collect()
                .forEach(System.out::println);



    }


}
