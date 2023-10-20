package hm5.Hibernate.Application;

import hm5.Hibernate.DAO.PersonDAO;
import hm5.Hibernate.Models.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.List;

/**
 * @author Stepan Morgachev
 * @date 18.10.2023 14:37
 */
public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        PersonDAO personDAO = new PersonDAO(sessionFactory);

        //Сохранение HQL
        /*Person person = new Person();
        person.setId(5);
        person.setFirstName("Leonid");
        person.setLastName("Raevskiy");
        person.setAge(22);
        person.setDateOfBirth(new Date(2001 - 1900, 10, 11));

        personDAO.createHQL(person);*/

        //Чтение HQL
        /*Person person = personDAO.readHQL(5);
        System.out.println(person);*/

        //Обновление записи HQL
        /*Person person = new Person();
        person.setId(5);
        person.setFirstName("Maxim");
        person.setLastName("Raevskiy");
        person.setAge(22);
        person.setDateOfBirth(new Date(2001 - 1900, 10, 11));

        personDAO.updateHQL(person);*/

        //Удаление записи HQL
        /*Person person = new Person();
        person.setId(5);
        person.setFirstName("Maxim");
        person.setLastName("Raevskiy");
        person.setAge(22);
        person.setDateOfBirth(new Date(2001 - 1900, 10, 11));

        personDAO.deleteHQL(person);*/

        //Выборка с пагинаией и сортировкой HQL
        /*List<Person> personList = personDAO.readAllHQL(1, 3, true);
        for(Person person: personList)
            System.out.println(person);*/

        //Выборка с сортировкой HQL
        /*List<Person> personList = personDAO.readAllHQL(true);
        for(Person person: personList)
            System.out.println(person);*/

        //Чтение записи Criteria
        /*Person person = personDAO.readCriteria(5);
        System.out.println(person);*/

        //Обновление Criteria
        /*Person person = new Person();
        person.setId(5);
        person.setFirstName("Anatoliy");
        person.setLastName("Raevskiy");
        person.setAge(22);
        person.setDateOfBirth(new Date(2001 - 1900, 10, 11));

        personDAO.updateCriteria(person);*/

        //Создание Criteria
        /*Person person = new Person();
        //person.setId(1);
        person.setFirstName("Petr");
        person.setLastName("Verhovenskiy");
        person.setAge(24);
        person.setDateOfBirth(new Date(1999 - 1900, 5, 19));

        personDAO.createCriteria(person);*/

        //Выборка с пагинаией и сортировкой Criteria
        /*List<Person> personList = personDAO.readAllCriteria(1, 4, true);
        for(Person person: personList)
            System.out.println(person);*/

        //Выборка с сотрировкой Criteria
        /*List<Person> personList = personDAO.readAllCriteria(true);
        for(Person person: personList)
            System.out.println(person);*/
    }
}
