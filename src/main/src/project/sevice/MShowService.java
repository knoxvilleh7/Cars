package project.sevice;

import project.exception.DaoException;
import project.exception.ValidException;
import project.model.MotorShow;

import java.util.List;

/**
 * Created on 15.08.2016.
 */
public interface MShowService {

    void mShowSave(MotorShow motorShow) throws ValidException;

    MotorShow getMShowById(Integer id);

    void delete(Integer id);

    List<MotorShow> getAllMotorShows(Integer pageNumber, Integer pageSize);

    List<MotorShow> getAllMotorShowsForRegistration();

    Long getMotorShowCount();

}
