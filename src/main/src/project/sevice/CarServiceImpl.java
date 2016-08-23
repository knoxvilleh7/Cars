package project.sevice;

import project.exception.ValidException;
import project.model.Car;
import project.newDao.CarDao;
import project.newDao.CarDaoImpl;
import project.newDao.NewDaoGenerics;
import project.newDao.NewDaoGenericsImpl;
import project.util.ModelValidator;

import java.util.List;
import java.util.Map;


public class CarServiceImpl implements CarService {

    private CarDao carDao = new CarDaoImpl(Car.class);
    private ModelValidator mv = new ModelValidator();

    public void saveCar(Car car) throws ValidException{
        Map<String, List<String>> err = mv.mValid(car);
        if (err.isEmpty()) {
            carDao.saveOrUpdate(car);
        } else {
            throw new ValidException(err);
        }
    }

    public List<Car> getCarsByMSId(Integer MotorShowId) {
        return carDao.getCarsByMSId(MotorShowId);
    }

    public Car getCarById(Integer id) {
        return carDao.getById(id);
    }

    public Car getCarByVin(String vinCode) {
        return null;
    }

    public List<Car> getCars() {
        return carDao.getAll();
    }


    public void deleteCar(Integer id) {
        carDao.deleteById(carDao.getById(id));
    }

}
