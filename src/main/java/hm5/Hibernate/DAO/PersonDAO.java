package hm5.Hibernate.DAO;

import hm5.Hibernate.Models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
    public void createHQL(Person person) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "INSERT INTO Person (id, firstName, lastName, age, dateOfBirth) " +
                    "VALUES (:id, :firstName, :lastName, :age, :dateOfBirth)";
            session.createQuery(hql)
                    .setParameter("id", person.getId())
                    .setParameter("firstName", person.getFirstName())
                    .setParameter("lastName", person.getLastName())
                    .setParameter("age", person.getAge())
                    .setParameter("dateOfBirth", person.getDateOfBirth())
                    .executeUpdate();

            transaction.commit();
        }
    }

    @Override
    public Person readHQL(int id) {
        Transaction transaction = null;
        Person person;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "FROM Person p WHERE p.id =:id";
            person = (Person) session.createQuery(hql)
                    .setParameter("id", id)
                    .uniqueResult();

            transaction.commit();
        }
        return person;
    }

    @Override
    public void updateHQL(Person person) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "update Person p set p.firstName = :newFirstName, p.lastName = :newLastName" +
                    ", p.age = :newAge, p.dateOfBirth = :newDateOfBirth where p.id = :id";
            session.createQuery(hql)
                    .setParameter("newFirstName", person.getFirstName())
                    .setParameter("newLastName", person.getLastName())
                    .setParameter("newAge", person.getAge())
                    .setParameter("newDateOfBirth", person.getDateOfBirth())
                    .setParameter("id", person.getId())
                    .executeUpdate();

            transaction.commit();
        }
    }

    @Override
    public void deleteHQL(Person person) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql = "delete Person p where p.id = :id";
            session.createQuery(hql)
                    .setParameter("id", person.getId())
                    .executeUpdate();

            transaction.commit();
        }
    }

    @Override
    public List<Person> readAllHQL(int page, int pageSize, boolean isSorted) {
        Transaction transaction = null;
        List<Person> result;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            if(isSorted) {
                String hql = "From Person Order by age";
                Query query = session.createQuery(hql)
                        .setFirstResult((page - 1) * pageSize)
                        .setMaxResults(pageSize);
                result = query.list();
            }else{
                String hql = "From Person";
                Query query = session.createQuery(hql)
                        .setFirstResult((page - 1) * pageSize)
                        .setMaxResults(pageSize);
                result = query.list();
            }
            transaction.commit();
        }
        return result;
    }

    @Override
    public List<Person> readAllHQL(boolean isSorted) {
        Transaction transaction = null;
        List<Person> result;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String hql;
            if(isSorted) {
                hql = "From Person Order by age";
            }else{
                hql = "From Person";
            }
            result = session.createQuery(hql).list();
            transaction.commit();
        }
        return result;
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
