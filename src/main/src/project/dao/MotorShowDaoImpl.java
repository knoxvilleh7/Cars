package project.dao;

import project.exception.DaoException;
import project.model.MotorShow;
import project.util.DBconnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static project.constants.MotorShowConst.*;

/**
 * Created on 15.08.2016.
 */
public class MotorShowDaoImpl extends ObjectDeleteImpl implements MotorShowDao {

    public List<MotorShow> getMotorShows() throws DaoException {

        List<MotorShow> mShows = new ArrayList<>();

        try (Connection connection = DBconnect.connCreate()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_MS);
            while (resultSet.next()) {
                MotorShow motorShow = new MotorShow();
                motorShow.setId(resultSet.getInt(MID));
                motorShow.setName(resultSet.getString(NAME));
                motorShow.setAddress(resultSet.getString(ADDRESS));
                mShows.add(motorShow);
            }
        } catch (SQLException e) {
            throw new DaoException("Can't get list of motor shows from base.");
        }
        return mShows;
    }

    public void saveMotorShow(MotorShow motorShow) throws DaoException {


        try (Connection connection = DBconnect.connCreate()) {
            PreparedStatement preparedStatement;
            if (motorShow.getId() != null) {
                preparedStatement = connection.prepareStatement(SQL_UPDATE_MS);
                preparedStatement.setInt(3, motorShow.getId());
            } else {
                preparedStatement = connection.prepareStatement(SQL_SAVE_MS);
            }
            preparedStatement.setString(1, motorShow.getName());
            preparedStatement.setString(2, motorShow.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            if (motorShow.getId() != null) {
                throw new DaoException("Can't update motor show info in database.");
            } else {
                throw new DaoException("Can't create motor show in database.");
            }
        }
    }

    public MotorShow getMotorShowById(Integer id) throws DaoException {

        MotorShow motorShow = null;
        try (Connection connection = DBconnect.connCreate()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_MS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next()) {
               motorShow = new MotorShow();
               motorShow.setId(id);
               motorShow.setName(resultSet.getString(NAME));
               motorShow.setAddress(resultSet.getString(ADDRESS));
           }
        } catch (SQLException e) {
            throw new DaoException("Can't get motor show from database.");
        }
        return motorShow;
    }

    public MotorShow getMotorShowByName(String name) throws DaoException {

        MotorShow motorShow = null;
        try (Connection connection = DBconnect.connCreate()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_MS_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next()) {
               motorShow = new MotorShow();
               motorShow.setId(resultSet.getInt(MID));
               motorShow.setName(name);
               motorShow.setAddress(resultSet.getString(ADDRESS));
           }
        } catch (SQLException e) {
            throw new DaoException("Can't get motor show from database.");
        }
        return motorShow;
    }

}
