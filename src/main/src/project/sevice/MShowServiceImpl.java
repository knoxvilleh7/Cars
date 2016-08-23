package project.sevice;

import project.newDao.MotorShowDao;
import project.newDao.MotorShowDaoImpl;
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

    private MotorShowDao motorShowDao = new MotorShowDaoImpl(MotorShow.class);
    private ModelValidator mv = new ModelValidator();

    public void mShowSave(MotorShow motorShow) throws ValidException{
        Map<String, List<String>> errs = mv.mValid(motorShow);
        if (errs.isEmpty()) {
            motorShowDao.saveOrUpdate(motorShow);
        } else {
            throw new ValidException(errs);
        }
    }

    public MotorShow getMShowById(Integer id){
        return motorShowDao.getById(id);
    }

    public void delete(Integer id){
        motorShowDao.deleteById(motorShowDao.getById(id));
    }

    public List<MotorShow> getAllMotorShows(){
        return motorShowDao.getAll();
    }

}
