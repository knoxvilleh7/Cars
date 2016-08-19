package project.util;

import net.sf.oval.constraint.CheckWithCheck;
import project.dao.CarDao;
import project.dao.CarDaoImpl;
import project.exception.DaoException;
import project.model.Car;

/**
 * Created on 16.08.2016.
 */
public class VinCheck implements CheckWithCheck.SimpleCheck {

    private CarDao carDao = new CarDaoImpl();

    public boolean isSatisfied(Object valObj, Object value) {

        if(valObj instanceof Car){
            Car carFromBase = null;
            try {
                carFromBase = carDao.getCarByVin(value.toString());
            } catch (DaoException e) {
                e.printStackTrace();
            }
            return carFromBase == null || (carFromBase.getId().equals(((Car) valObj).getId()));
        }

        return false;
    }
}
