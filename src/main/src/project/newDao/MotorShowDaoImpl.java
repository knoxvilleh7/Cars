package project.newDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.model.MotorShow;

import java.util.List;

@Component
@Transactional
public class MotorShowDaoImpl extends NewDaoGenericsImpl<MotorShow> implements MotorShowDao {

    public MotorShowDaoImpl() {
        super(MotorShow.class);
    }
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    private static final Logger logger = LoggerFactory.getLogger(MotorShowDao.class);

    @SuppressWarnings("unchecked")
    public List<MotorShow> getAllMotorShowsForRegistration() {
        Session session = sessionFactory.openSession();
        List<MotorShow> objs = null;
        try {
            objs = (List<MotorShow>) session.createCriteria(MotorShow.class).list();
//            logger.info("List of motorShows successfully loaded="+objs);

        } catch (RuntimeException ignored) {
        }
        return objs;
    }
}