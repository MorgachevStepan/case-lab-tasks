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

        //Обновление записи
        /*Person person = new Person();
        person.setId(5);
        person.setFirstName("Maxim");
        person.setLastName("Raevskiy");
        person.setAge(22);
        person.setDateOfBirth(new Date(2001 - 1900, 10, 11));

        personDAO.updateHQL(person);*/

        //Удаление записи
        /*Person person = new Person();
        person.setId(5);
        person.setFirstName("Maxim");
        person.setLastName("Raevskiy");
        person.setAge(22);
        person.setDateOfBirth(new Date(2001 - 1900, 10, 11));

        personDAO.deleteHQL(person);*/

        //Выборка с пагинаией и сортировкой
        /*List<Person> personList = personDAO.readAllHQL(1, 3, true);
        for(Person person: personList)
            System.out.println(person);*/

        //Выборка с сортировкой
        /*List<Person> personList = personDAO.readAllHQL(true);
        for(Person person: personList)
            System.out.println(person);*/
    }
}
