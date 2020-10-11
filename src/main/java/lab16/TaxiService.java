package lab16;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
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


        JavaPairRDD<Integer, Integer> driversRdd = orders
                .map(row -> row.split("\\s"))
                .mapToPair(elem -> new Tuple2<>(Integer.parseInt(elem[0]),Integer.parseInt(elem[2])))
                .reduceByKey(Integer::sum)
                .mapToPair(Tuple2::swap)
                .mapToPair(Tuple2::swap);

        JavaPairRDD<Integer, String> namesRdd = drivers
                .map(row -> row.split(", "))
                .mapToPair(elem -> new Tuple2<>(Integer.parseInt(elem[0]), elem[1]));

        JavaPairRDD<Integer, Tuple2<Integer, String>> joinRdd = driversRdd
                .join(namesRdd)
                .sortByKey(false);

        System.out.format("Number of lines in `taxi_orders.txt`: %d\n", numberOfRows);
        System.out.format("Number of trips to Boston longer than 10 km: %d\n", numberOfTrips);
        System.out.format("Amount of all trips to Boston in kilometers: %d\n", sumOfKms);
        joinRdd.take(3).forEach(row -> System.out.format("Driver with biggest amount of kms: %s\n", row._2._2()));

    }

}
