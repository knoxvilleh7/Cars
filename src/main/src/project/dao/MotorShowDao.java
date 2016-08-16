package project.dao;

import project.model.MotorShow;

import java.util.List;

/**
 * Created on 15.08.2016.
 */
public interface MotorShowDao {
    String SQL_GET_ALL_MS = "SELECT * FROM motorshows";
    String SQL_SAVE_MS = "INSERT INTO motorshows (name, address) VALUES (?,?);";
    String SQL_UPDATE_MS = "UPDATE motorshows SET name=?,  address=? WHERE id=?";
    String SQL_GET_MS_BY_ID = "SELECT * FROM motorshows WHERE id=?";
    String SQL_GET_MS_BY_NAME = "SELECT * FROM motorshows WHERE name=?";
    String SQL_DELETE_MS = "DELETE FROM motorshows WHERE id = ?";
    
    List<MotorShow> getMotorShows();

    void saveMotorShow(MotorShow motorShow);

    MotorShow getMotorShowById(Integer id);

    MotorShow getMotorShowByName(String name);

    void deleteMotorShow(Integer id);
}
