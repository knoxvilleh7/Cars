package project.sevice;

import project.dao.MotorShowDao;
import project.dao.MotorShowDaoImpl;
import project.exception.DaoException;
import project.exception.ValidException;
import project.model.MotorShow;
import project.util.ModelValidator;

import java.util.List;
import java.util.Map;

/**
 * Created on 15.08.2016.
 */
public class MShowServiceImpl implements MShowService {

    private MotorShowDao motorShowDao = new MotorShowDaoImpl();
    private ModelValidator mv = new ModelValidator();

    public void mShowSave(MotorShow motorShow) throws ValidException, DaoException {
        Map<String, List<String>> errs = mv.mValid(motorShow);
        if (errs.isEmpty()) {
            motorShowDao.saveMotorShow(motorShow);
        } else {
            throw new ValidException(errs);
        }
    }

    public MotorShow getMShowById(Integer id) throws DaoException {
        return motorShowDao.getMotorShowById(id);
    }

    public void delete(Integer id) throws DaoException {
        motorShowDao.delete("motorshows", id);
    }

    public List<MotorShow> getAllMotorShows() throws DaoException {
        return motorShowDao.getMotorShows();
    }

}
