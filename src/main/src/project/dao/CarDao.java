package project.dao;

import project.exception.DaoException;
import project.model.Car;

import java.util.List;

/**
 * Created on 15.08.2016.
 */
public interface CarDao extends ObjectDelete{

    String SQL_GET_ALL_CARS = "SELECT * FROM cars";
    String SQL_SAVE_CAR = "INSERT INTO cars(model, manufactureremail,  productiondate," +
            "motorshowid, manufacturer, price, enginevolume, vincode) VALUES (?,?,?,?,?,?,?,?);";
    String SQL_UPDATE_CAR = "UPDATE cars SET model=?,  manufactureremail=?, productiondate=?, motorshowid =?," +
            "manufacturer=?, price=?, enginevolume=?, vincode=? WHERE id=?";
    String SQL_GET_CAR_BY_ID = "SELECT * FROM cars WHERE id=?";
    String SQL_GET_CAR_BY_VIN = "SELECT * FROM cars WHERE vincode=?";
    String SQL_GET_CARS_BY_MSID = "SELECT * FROM cars WHERE motorshowid=?";


    List<Car> getCars() throws DaoException;

    void saveCar(Car car) throws DaoException;

    Car getCarById(Integer id) throws DaoException;

    Car getCarByVin(String vin) throws DaoException;



    List<Car> getCarsByMSId(Integer msid) throws DaoException;
}
