package project.newDao;

import java.util.List;

/**
 * Created on 23.08.2016.
 */
public interface NewDaoGenerics<T> {

    String HQL_CAR_COUNT = "select count (*) from Car car";
    String HQL_CAR_COUNT_OF_MOTOR_SHOW = "select count (*) from Car car where car.motorShowId=:id";
    String HQL_MOTOR_SHOW_COUNT = "select count (*) from MotorShow motorShow";

    void saveOrUpdate(T obj);

    T getById(Integer id);

    List<T> getAll(Integer pageNumber, Integer pageSize);

    void deleteById(T obj);

    Long getCount(String table, Integer id);
}
