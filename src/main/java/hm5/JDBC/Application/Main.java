package hm5.JDBC.Application;

import hm5.JDBC.DAO.PersonDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        }catch (SQLException sqlException){
            System.err.println(sqlException.getMessage());
        }
    }
}
