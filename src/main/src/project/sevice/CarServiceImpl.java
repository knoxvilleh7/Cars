package project.sevice;

import project.dao.CarDao;
import project.dao.CarDaoImpl;
import project.exception.DaoException;
import project.exception.ValidException;
import project.model.Car;
import project.util.ModelValidator;

import java.util.List;
import java.util.Map;

/**
 * Created on 15.08.2016.
 */
public class CarServiceImpl implements CarService {

    private CarDao carDao = new CarDaoImpl();
    private ModelValidator mv = new ModelValidator();

    public void saveCar(Car car) throws ValidException, DaoException {
        Map<String, List<String>> err = mv.mValid(car);
        if (err.isEmpty()) {
            carDao.saveCar(car);
        } else {
            throw new ValidException(err);
        }
    }

    public List<Car> getCarsByMSId(Integer MotorShowId) throws DaoException {
        return carDao.getCarsByMSId(MotorShowId);
    }

    public Car getCarById(Integer id) throws DaoException {
        return carDao.getCarById(id);
    }

    public void deleteCar(Integer id) throws DaoException {
        carDao.delete("cars", id);

    }
}
