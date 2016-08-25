package project.newDao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.util.HibernateUtil;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

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
        }
        return obj;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll(Integer pageNumber, Integer pageSize) {


        Session session = null;
        Transaction tx = null;
        List<T> objs = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(aClass);
            criteria.setFirstResult((pageNumber - 1) * pageSize);
            criteria.setMaxResults(pageSize);
            objs = (List<T>) criteria.list();
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

    @SuppressWarnings("unchecked")
    public Long getCount(String table, Integer id) {

        Session session = null;
        Transaction tx = null;
        Long count = null;
        Query query;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            if (Objects.equals(table, "car")) {
                if (id == null) {
                    query = session.createQuery(HQL_CAR_COUNT);
                }else {
                    query = session.createQuery(HQL_CAR_COUNT_OF_MOTOR_SHOW);
                    query.setParameter("id", id);
                }
            } else {
                query = session.createQuery(HQL_MOTOR_SHOW_COUNT);
            }
            count = (Long) query.uniqueResult();
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
        return count;
    }
}