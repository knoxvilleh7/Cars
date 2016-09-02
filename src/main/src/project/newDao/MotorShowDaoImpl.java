package project.newDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import project.model.MotorShow;

import java.util.List;

@Repository
public class MotorShowDaoImpl extends NewDaoGenericsImpl<MotorShow> implements MotorShowDao {

    public MotorShowDaoImpl(Class aClass) {
        super(aClass);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final Logger logger = LoggerFactory.getLogger(MotorShowDao.class);

    @SuppressWarnings("unchecked")
    public List<MotorShow> getAllMotorShowsForRegistration() {
        Session session = sessionFactory.getCurrentSession();
        List<MotorShow> objs = null;
        try {
            objs = (List<MotorShow>) session.createCriteria(aClass).list();
            logger.info("List of motorShows successfully loaded="+objs);

        } catch (RuntimeException ignored) {
        }
        return objs;
    }
}
