package project.util;

import project.exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created on 15.08.2016.
 */
public class DBconnect {

    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost:3306/registration";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection connCreate() throws DaoException {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new DaoException("Can't get connection to base.");
        }
        return connection;
    }

    public static void connClose(Connection connection) throws DaoException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            throw new DaoException("Can't close connection to base.");
        }
    }

}
