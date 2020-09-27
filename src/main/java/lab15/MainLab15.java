package lab15;

import lab14.Customer;
import java.util.AbstractMap;
import java.util.stream.Stream;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Pavel Zeger
 */
public class MainLab15 {

    public static void main(String[] args) {

        Stream<Customer> stream = Stream.of(
                Customer.builder().firstName("John").lastName("Tramp").age(77).build(),
                Customer.builder().firstName("Aaron").lastName("Lancaster").age(39).build(),
                Customer.builder().firstName("Paul").lastName("Courtney").age(22).build(),
                Customer.builder().firstName("Garry").lastName("Garrison").age(87).build(),
                Customer.builder().firstName("Steve").lastName("Jobber").age(50).build(),
                Customer.builder().firstName("Jack").lastName("Tram").age(77).build(),
                Customer.builder().firstName("Aaron").lastName("Funk").age(39).build(),
                Customer.builder().firstName("Paul").lastName("Mac").age(22).build(),
                Customer.builder().firstName("Abraham").lastName("Motors").age(87).build(),
                Customer.builder().firstName("George").lastName("Push").age(50).build());

        stream.map(customer -> new AbstractMap.SimpleEntry<>(customer.getAge(), customer.getFirstName()))
                .collect(groupingBy(AbstractMap.SimpleEntry::getKey))
                .forEach((age, names) -> System.out.println(age + "=" + names));

    }

}
