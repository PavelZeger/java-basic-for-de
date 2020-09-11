package lab14;

import org.junit.Test;
import java.util.List;

/**
 * @author Pavel Zeger
 */
public class ListUtilsTest {

    @Test
    public void getAverageTest() {
        List<Customer> customers = List.of(
                Customer.builder().firstName("John").lastName("Trampy").age(77).build(),
                Customer.builder().firstName("Aaron").lastName("Boidem").age(39).build(),
                Customer.builder().firstName("Paul").lastName("Courtney").age(22).build(),
                Customer.builder().firstName("Shisdob").lastName("Sdob").age(87).build(),
                Customer.builder().firstName("Oywawoy").lastName("Trap").age(50).build()
        );
        int averageExpected = 55;
        int averageActual = ListUtils.getAverageAge(customers);
        assert(averageExpected == averageActual);
    }

}