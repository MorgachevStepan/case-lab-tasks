package hm5.JDBC.DAO;

import hm5.JDBC.Models.Person;

import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 17.10.2023 13:19
 */
public interface PersonDAO {
    void create(Person person);
    Person read(int id);
    void update(Person person);
    void delete(Person person);
    List<Person> readAll(int pageSize, boolean isSorted);
}
