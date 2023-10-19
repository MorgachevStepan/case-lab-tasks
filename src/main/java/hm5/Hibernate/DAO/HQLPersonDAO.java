package hm5.Hibernate.DAO;

import hm5.Hibernate.Models.Person;

import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 18.10.2023 14:43
 */
public interface HQLPersonDAO {
    void createHQL(Person person);
    Person readHQL(int id);
    void updateHQL(Person person);
    void deleteHQL(Person person);
    List<Person> readAllHQL(int page, int pageSize, boolean isSorted);
    List<Person> readAllHQL(boolean isSorted);
}
