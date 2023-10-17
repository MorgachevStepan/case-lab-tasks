package hm5.JDBC.DAO;

import hm5.JDBC.Models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Stepan Morgachev
 * @date 17.10.2023 13:23
 */
public class PersonDAOImpl implements PersonDAO{
    private final Connection connection;

    public PersonDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Person person) {
        if(isExist(person.getId())){
            System.out.println("Запись с таким идентификатором существует");
            return false;
        }

        boolean result = false;

        String expression = "INSERT INTO person (id, first_name, last_name, age, date_of_birth) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(expression);
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setInt(4, person.getAge());
            preparedStatement.setDate(5, person.getDateOfBirth());

            if(preparedStatement.executeUpdate() == 1){
                result = true;
                System.out.println("Была добавлена 1 строка");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    private boolean isExist(int id) {
        return read(id).getId() != -1;
    }

    @Override
    public Person read(int id) {
        Person person = new Person();
        person.setId(-1);
        String expression = "SELECT * FROM person WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(expression);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                person.setId(resultSet.getInt("id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setAge(resultSet.getInt("age"));
                person.setDateOfBirth(resultSet.getDate("date_of_birth"));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        if(person.getId() == -1){
            System.out.println("Записи с таким идентификатором не существует");
        }

        return person;
    }

    @Override
    public boolean update(Person person) {
        if(!isExist(person.getId())){
            System.out.println("Записи с таким идентификатором не существует");
            return false;
        }
        boolean result = false;

        String expression = "UPDATE person SET first_name = ?, last_name = ?, age = ?, date_of_birth = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(expression);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.setDate(4, person.getDateOfBirth());
            preparedStatement.setInt(5, person.getId());

            if(preparedStatement.executeUpdate() == 1){
                result = true;
                System.out.println("Была обновлена 1 строка");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    @Override
    public boolean delete(Person person) {
        if(!isExist(person.getId())){
            System.out.println("Записи с таким идентификатором не существует");
            return false;
        }

        boolean result = false;

        String expression = "DELETE FROM person WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(expression);
            preparedStatement.setInt(1, person.getId());

            if(preparedStatement.executeUpdate() == 1) {
                System.out.println("Была удалена 1 строка");
                result = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    @Override
    public List<Person> readAll(int pageSize, boolean isSorted) {
        String expression = "SELECT * FROM person WHERE id < ?";
        List<Person> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(expression);
            preparedStatement.setInt(1, pageSize + 1);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                person.setAge(resultSet.getInt("age"));
                person.setDateOfBirth(resultSet.getDate("date_of_birth"));

                result.add(person);
            }

            if(isSorted) {
                result = result.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }
}
