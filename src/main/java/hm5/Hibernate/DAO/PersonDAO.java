package hm5.Hibernate.DAO;

import hm5.JDBC.Models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 18.10.2023 14:49
 */
public class PersonDAO implements HQLPersonDAO, CriteriaPersonDAO{
    private final SessionFactory sessionFactory;

    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean createHQL(Person person) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "INSERT INTO person";

        }

        return false;
    }

    @Override
    public Person readHQL(int id) {
        return null;
    }

    @Override
    public boolean updateHQL(Person person) {
        return false;
    }

    @Override
    public boolean deleteHQL(Person person) {
        return false;
    }

    @Override
    public List<Person> readAllHQL(int page, int pageSize, boolean isSorted) {
        return null;
    }

    @Override
    public List<Person> readAllHQL(boolean isSorted) {
        return null;
    }

    @Override
    public boolean createCriteria(Person person) {
        return false;
    }

    @Override
    public Person readCriteria(int id) {
        return null;
    }

    @Override
    public boolean updateCriteria(Person person) {
        return false;
    }

    @Override
    public boolean deleteCriteria(Person person) {
        return false;
    }

    @Override
    public List<Person> readAllCriteria(int page, int pageSize, boolean isSorted) {
        return null;
    }

    @Override
    public List<Person> readAllCriteria(boolean isSorted) {
        return null;
    }
}
