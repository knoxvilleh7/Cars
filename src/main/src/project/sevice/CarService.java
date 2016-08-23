package project.sevice;

import project.exception.DaoException;
import project.exception.ValidException;
import project.model.Car;

import java.util.List;

/**
 * Created on 15.08.2016.
 */
public interface CarService {

    void saveCar(Car car) throws ValidException, DaoException;

    List<Car> getCarsByMSId(Integer motorShowId);

    Car getCarById(Integer id);

    Car getCarByVin(String vinCode);

    List<Car> getCars();

    void deleteCar(Integer id);
}
