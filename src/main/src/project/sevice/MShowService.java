package project.sevice;

import project.exception.DaoException;
import project.exception.ValidException;
import project.model.MotorShow;

import java.util.List;

/**
 * Created on 15.08.2016.
 */
public interface MShowService {

    void mShowSave(MotorShow motorShow) throws ValidException, DaoException;

    MotorShow getMShowById(Integer id) throws DaoException;

    void delete(Integer id) throws DaoException;

    List<MotorShow>  getAllMotorShows() throws DaoException;
}
