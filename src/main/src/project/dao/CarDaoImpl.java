package project.dao;

import project.exception.DaoException;
import project.model.Car;
import project.util.DBconnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static project.constants.CarConst.*;

/**
 * Created on 15.08.2016.
 */
public class CarDaoImpl extends ObjectDeleteImpl implements CarDao {

    public List<Car> getCars() throws DaoException {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DBconnect.connCreate()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_CARS);
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt(ID));
                car.setModel(resultSet.getString(MODEL));
                car.setProductionDate(resultSet.getDate(PD));
                car.setManufacturerEmail(resultSet.getString(MEMAIL));
                car.setMotorShowId(resultSet.getInt(MSID));
                car.setManufacturer(resultSet.getString(MANUFACTURER));
                car.setPrice(resultSet.getDouble(PRICE));
                car.setEngineVolume(resultSet.getDouble(EVOL));
                car.setVinCode(resultSet.getString(VIN));
                cars.add(car);
            }
        } catch (Exception e) {
            throw new DaoException("Can't get list of all cars from database.");
        }
        return cars;
    }

    public void saveCar(Car car) throws DaoException {

        try (Connection connection = DBconnect.connCreate()) {
            PreparedStatement preparedStatement;
            if (car.getId() != null) {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_CAR);
                preparedStatement.setInt(9, car.getId());
            } else {
                preparedStatement = connection.prepareStatement(SQL_SAVE_CAR);
            }
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setString(2, car.getManufacturerEmail());
            preparedStatement.setDate(3, car.getProductionDate());
            preparedStatement.setInt(4, car.getMotorShowId());
            preparedStatement.setString(5, car.getManufacturer());
            preparedStatement.setDouble(6, car.getPrice());
            preparedStatement.setDouble(7, car.getEngineVolume());
            preparedStatement.setString(8, car.getVinCode());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            if (car.getId() != null) {
                throw new DaoException("Can't update car info in database.");
            } else {
                throw new DaoException("Can't create car in database.");
            }
        }
    }

    public Car getCarById(Integer id) throws DaoException {

        Car car = null;
        try (Connection connection = DBconnect.connCreate()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt(ID));
                car.setModel(resultSet.getString(MODEL));
                car.setProductionDate(resultSet.getDate(PD));
                car.setManufacturerEmail(resultSet.getString(MEMAIL));
                car.setMotorShowId(resultSet.getInt(MSID));
                car.setManufacturer(resultSet.getString(MANUFACTURER));
                car.setPrice(resultSet.getDouble(PRICE));
                car.setEngineVolume(resultSet.getDouble(EVOL));
                car.setVinCode(resultSet.getString(VIN));
            }
        } catch (SQLException e) {
            throw new DaoException("Can't get car from database.");
        }
        return car;
    }

    public Car getCarByVin(String vin) throws DaoException {

        Car car = null;
        try (Connection connection = DBconnect.connCreate()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_BY_VIN);
            preparedStatement.setString(1, vin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt(ID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }


    public List<Car> getCarsByMSId(Integer MotorShowId) throws DaoException {

        List<Car> cars = new ArrayList<>();
        try (Connection connection = DBconnect.connCreate()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CARS_BY_MSID);
            preparedStatement.setInt(1, MotorShowId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt(ID));
                car.setModel(resultSet.getString(MODEL));
                car.setProductionDate(resultSet.getDate(PD));
                car.setManufacturerEmail(resultSet.getString(MEMAIL));
                car.setMotorShowId(MotorShowId);
                car.setManufacturer(resultSet.getString(MANUFACTURER));
                car.setPrice(resultSet.getDouble(PRICE));
                car.setEngineVolume(resultSet.getDouble(EVOL));
                car.setVinCode(resultSet.getString(VIN));
                cars.add(car);
            }
        } catch (SQLException e) {
            throw new DaoException("Can't get list of this motor show cars from database.");
        }
        return cars;

    }
}
