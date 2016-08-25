package project.newDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import project.model.Car;
import project.util.HibernateUtil;

import java.util.List;

public class CarDaoImpl extends NewDaoGenericsImpl<Car> implements CarDao {

    public CarDaoImpl(Class aClass) {
        super(aClass);
    }


    public Car getCarByVin(String vinCode) {
        Session session = null;
        Transaction tx = null;
        Car car = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            car = session.load(Car.class, vinCode);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return car;
    }

    @SuppressWarnings("unchecked")
    public List<Car> getCarsByMSId(Integer MotorShowId, Integer pageNumber, Integer pageSize) {

        Session session = null;
        Transaction tx = null;
        List<Car> cars = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Car.class).add(Restrictions.eq("motorShowId", MotorShowId));
        criteria.setFirstResult((pageNumber - 1) * pageSize);
        criteria.setMaxResults(pageSize);
            cars = criteria.list();
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return cars;
    }
}

