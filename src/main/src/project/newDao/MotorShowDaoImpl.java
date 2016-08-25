package project.newDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.model.MotorShow;
import project.util.HibernateUtil;

import java.util.List;

/**
 * Created on 22.08.2016.
 */
public class MotorShowDaoImpl extends NewDaoGenericsImpl<MotorShow> implements MotorShowDao {

    public MotorShowDaoImpl(Class aClass) {
        super(aClass);
    }

    @SuppressWarnings("unchecked")
    public List<MotorShow> getAllMotorShowsForRegistration() {
        Session session = null;
        Transaction tx = null;
        List<MotorShow> objs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            objs = (List<MotorShow>) session.createCriteria(aClass).list();
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
        return objs;
    }
}
