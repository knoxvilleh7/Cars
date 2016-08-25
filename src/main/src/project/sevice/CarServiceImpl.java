package project.sevice;

import project.exception.ValidException;
import project.model.Car;
import project.model.MotorShow;
import project.newDao.CarDao;
import project.newDao.CarDaoImpl;
import project.newDao.NewDaoGenerics;
import project.newDao.NewDaoGenericsImpl;
import project.util.ModelValidator;

import java.util.List;
import java.util.Map;

import static project.constants.AttributeConst.CAR;


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

    public List<Car> getCarsByMSId(Integer MotorShowId, Integer pageNumber, Integer pageSize) {
        return carDao.getCarsByMSId(MotorShowId, pageNumber, pageSize);
    }

    public Car getCarById(Integer id) {
        return carDao.getById(id);
    }

    public Car getCarByVin(String vinCode) {
        return null;
    }

    public List<Car> getCars(Integer pageNumber, Integer pageSize) {
        return carDao.getAll(pageNumber, pageSize);
    }

    public Long getCarCount(){
       return carDao.getCount(CAR, null);
    }

    @Override
    public Long getCarOfShowCount(Integer motorShowId) {
        return carDao.getCount(CAR, motorShowId );
    }

    public void deleteCar(Integer id) {
        carDao.deleteById(carDao.getById(id));
    }

}
