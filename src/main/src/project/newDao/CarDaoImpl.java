package project.newDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import project.model.Car;

import java.util.List;

@Repository
public class CarDaoImpl extends NewDaoGenericsImpl<Car> implements CarDao {

    public CarDaoImpl(Class aClass) {
        super(aClass);
    }
    //??????????

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Logger logger = LoggerFactory.getLogger(CarDao.class);

    @SuppressWarnings("unchecked")
    public List<Car> getCarsByMSId(Integer MotorShowId, Integer pageNumber, Integer pageSize) {

        Session session = sessionFactory.getCurrentSession();
        List<Car> cars = null;
        try {

            Criteria criteria = session.createCriteria(Car.class).add(Restrictions.eq("motorShowId", MotorShowId));
            criteria.setFirstResult((pageNumber - 1) * pageSize);
            criteria.setMaxResults(pageSize);
            cars = criteria.list();
            logger.info("List of cars successfully loaded="+cars);
        } catch (RuntimeException ignored) {
        }
        return cars;
    }

    @Override
    public Car getByVin(String vinCode) {
        Session session = sessionFactory.getCurrentSession();
        Car car = null;
        try {
            Criteria criteria = session.createCriteria(Car.class).add(Restrictions.eq("vinCode", vinCode));
            List<Car> result = criteria.list();
            if (result != null && !result.isEmpty()) {
                car = result.get(0);
            }
//            отэто по id достает, а не по стринге какого-то поля
            logger.info("Car successfully loaded="+car);

        } catch (RuntimeException ignored) {
        }
        return car;
    }
}

