package hm5.JDBC.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author Stepan Morgachev
 * @date 17.10.2023 13:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Date dateOfBirth;
}
