package project.dao;

import project.model.Car;

import java.util.List;

/**
 * Created on 15.08.2016.
 */
public interface CarDao {

    String SQL_GET_ALL_CARS = "SELECT * FROM cars";
    String SQL_SAVE_CAR = "INSERT INTO cars(model, manufactureremail,  productiondate," +
            "motorshowid, manufacturer, price, enginevolume, vincode) VALUES (?,?,?,?,?,?,?,?);";
    String SQL_UPDATE_CAR = "UPDATE cars SET model=?,  manufactureremail=?, productiondate=?, motorshowid =?," +
            "manufacturer=?, price=?, enginevolume=?, vincode=? WHERE id=?";
    String SQL_GET_CAR_BY_ID = "SELECT * FROM cars WHERE id=?";
    String SQL_GET_CAR_BY_VIN = "SELECT * FROM cars WHERE vincode=?";
    String SQL_GET_CARS_BY_MSID = "SELECT * FROM cars WHERE motorshowid=?";
    String SQL_DELETE_CAR = "DELETE FROM cars WHERE id = ?";

    List<Car> getCars();

    void saveCar(Car car);

    Car getCarById(Integer id);

    Car getCarByVin(Integer vin);

    void deleteCar(Integer id);

    List<Car> getCarsByMSId(Integer msid);
}
