package hm5.Hibernate.DAO;

import hm5.Hibernate.Models.Person;

import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 18.10.2023 14:57
 */
public interface CriteriaPersonDAO {
    void createCriteria(Person person);
    Person readCriteria(int id);
    void updateCriteria(Person person);
    void deleteCriteria(Person person);
    List<Person> readAllCriteria(int page, int pageSize, boolean isSorted);
    List<Person> readAllCriteria(boolean isSorted);
}
