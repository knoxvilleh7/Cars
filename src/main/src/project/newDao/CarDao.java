package project.newDao;

import project.model.Car;

import java.util.List;

/**
 * Created on 21.08.2016.
 */
public interface CarDao extends NewDaoGenerics<Car>{

    List<Car> getCarsByMSId(Integer MotorShowId, Integer pageNumber, Integer pageSize);

    Car getByVin(String VinCode);

}
