package hm5.JDBC.DAO;

import hm5.JDBC.Models.Person;

import java.util.List;
import java.util.Optional;

/**
 * @author Stepan Morgachev
 * @date 17.10.2023 13:19
 */
public interface PersonDAO {
    boolean create(Person person);
    Person read(int id);
    boolean update(Person person);
    boolean delete(Person person);
    List<Person> readAll(int pageSize, boolean isSorted);
}
