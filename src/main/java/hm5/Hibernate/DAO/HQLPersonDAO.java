package hm5.Hibernate.DAO;

import hm5.JDBC.Models.Person;

import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 18.10.2023 14:43
 */
public interface HQLPersonDAO {
    boolean createHQL(Person person);
    Person readHQL(int id);
    boolean updateHQL(Person person);
    boolean deleteHQL(Person person);
    List<Person> readAllHQL(int page, int pageSize, boolean isSorted);
    List<Person> readAllHQL(boolean isSorted);
}
