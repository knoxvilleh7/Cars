package project.dao;

import project.exception.DaoException;
import project.model.MotorShow;

import java.util.List;

/**
 * Created on 15.08.2016.
 */
public interface MotorShowDao extends ObjectDelete{
    String SQL_GET_ALL_MS = "SELECT * FROM motorshows";
    String SQL_SAVE_MS = "INSERT INTO motorshows (name, address) VALUES (?,?);";
    String SQL_UPDATE_MS = "UPDATE motorshows SET name=?,  address=? WHERE id=?";
    String SQL_GET_MS_BY_ID = "SELECT * FROM motorshows WHERE id=?";
    String SQL_GET_MS_BY_NAME = "SELECT * FROM motorshows WHERE name=?";

    
    List<MotorShow> getMotorShows() throws DaoException;

    void saveMotorShow(MotorShow motorShow) throws DaoException;

    MotorShow getMotorShowById(Integer id) throws DaoException;

    MotorShow getMotorShowByName(String name) throws DaoException;


}
