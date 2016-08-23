package project.newDao;

import java.util.List;

/**
 * Created on 23.08.2016.
 */
public interface NewDaoGenerics<T> {

    void saveOrUpdate(T obj);

    T getById(Integer id);

    List<T> getAll();

    void deleteById(T obj);
}
