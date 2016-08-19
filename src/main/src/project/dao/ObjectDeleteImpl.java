package project.dao;

import project.exception.DaoException;
import project.util.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created on 17.08.2016.
 */
public class ObjectDeleteImpl implements ObjectDelete {


    public void delete(String table, Integer id) throws DaoException {


        try (Connection connection = DBconnect.connCreate()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setString(1, table);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            if (table.equals("cars")) {
                throw new DaoException("Can't delete car from database.");
            } else {
                throw new DaoException("Can't delete motor show from database.");
            }
        }
    }
}
