package project.dao;

import project.exception.DaoException;

/**
 * Created on 17.08.2016.
 */
public interface ObjectDelete {

    String SQL_DELETE = "DELETE FROM ? WHERE id = ?";

    void delete(String table, Integer id) throws DaoException;

}
