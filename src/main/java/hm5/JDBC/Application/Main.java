package hm5.JDBC.Application;

import hm5.JDBC.DAO.PersonDAOImpl;
import hm5.JDBC.Models.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Stepan Morgachev
 * @date 17.10.2023 13:23
 */
public class Main {
    public static void main(String[] args) {
        final String user = "postgres";
        final String password = "1234";
        final String url = "jdbc:postgresql://localhost:5433/case_lab";

        try(Connection connection = DriverManager.getConnection(url, user, password)){
            PersonDAOImpl personDAO = new PersonDAOImpl(connection);

            //Добавление людей
            /*Person person1 = new Person();
            person1.setId(2);
            person1.setFirstName("Alexey");
            person1.setLastName("Plotov");
            person1.setAge(23);
            person1.setDateOfBirth(new Date(2000 - 1900, 7, 19));

            Person person2 = new Person();
            person2.setId(3);
            person2.setFirstName("Dmitriy");
            person2.setLastName("Dmitrov");
            person2.setAge(7);
            person2.setDateOfBirth(new Date(2016 - 1900, 5, 1));

            Person person3 = new Person();
            person3.setId(4);
            person3.setFirstName("Anatoliy");
            person3.setLastName("Serov");
            person3.setAge(34);
            person3.setDateOfBirth(new Date(1989 - 1900, 6, 23));

            personDAO.create(person1);
            personDAO.create(person2);
            personDAO.create(person3);*/

            //Общий вывод
            /*List<Person> personList = personDAO.readAll(3, false);
            for(Person person: personList){
                System.out.println(person);
            }*/

            //Чтение одной записи
            /*Person person = personDAO.read(2);
            System.out.println(person);*/

            //Удаление записи
            //personDAO.delete(personDAO.read(2));

            //Обновление записи
            //personDAO.update(new Person(4, "Anatoliy", "Serov", 35, new Date(1989 - 1900, 6, 24)));


        }catch (SQLException sqlException){
            System.err.println(sqlException.getMessage());
        }
    }
}
