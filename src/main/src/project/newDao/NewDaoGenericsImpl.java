package project.newDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.util.HibernateUtil;

import java.util.List;

/**
 * Created on 23.08.2016.
 */
public class NewDaoGenericsImpl<T> implements NewDaoGenerics<T> {

    protected Class aClass;

    public NewDaoGenericsImpl(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public void saveOrUpdate(T obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
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
    }


    @Override
    @SuppressWarnings("unchecked")
    public T getById(Integer id) {

        Session session = null;
        Transaction tx = null;
        T obj = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            obj = (T) session.get(aClass, id);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        } return obj;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {


        Session session = null;
        Transaction tx = null;
        List<T> objs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            objs = (List<T>) session.createCriteria(aClass).list();
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

    @Override
    public void deleteById(T obj) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(obj);
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
    }
}
