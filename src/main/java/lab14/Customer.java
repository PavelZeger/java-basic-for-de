package lab14;

import lombok.*;

/**
 * @author Pavel Zeger
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Customer {
    private String firstName;
    private String lastName;
    private int age;

}
