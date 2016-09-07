package project.newDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.model.Car;

import java.util.List;

@Component
@Transactional
public class CarDaoImpl extends NewDaoGenericsImpl<Car> implements CarDao {

    public CarDaoImpl() {
        super(Car.class);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Logger logger = LoggerFactory.getLogger(CarDao.class);

    @SuppressWarnings("unchecked")
    public List<Car> getCarsByMSId(Integer MotorShowId, Integer pageNumber, Integer pageSize) {

        Session session = sessionFactory.openSession();
        List<Car> cars = null;
        try {

            Criteria criteria = session.createCriteria(Car.class).add(Restrictions.eq("motorShow.id", MotorShowId));
            criteria.setFirstResult((pageNumber - 1) * pageSize);
            criteria.setMaxResults(pageSize);
            cars = criteria.list();
            logger.info("List of cars successfully loaded="+cars);
        } catch (RuntimeException ignored) {
        }
        return cars;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Car getByVin(String vinCode) {
        Session session = sessionFactory.openSession();
        Car car = null;
        try {
            Criteria criteria = session.createCriteria(Car.class).add(Restrictions.eq("vinCode", vinCode));
            List<Car> result = criteria.list();
            if (result != null && !result.isEmpty()) {
                car = result.get(0);
            }
            logger.info("Car successfully loaded="+car);

        } catch (RuntimeException ignored) {
        }
        return car;
    }
}

