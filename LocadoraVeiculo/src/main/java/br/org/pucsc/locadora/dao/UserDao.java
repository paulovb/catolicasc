/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.pucsc.locadora.dao;

import br.org.pucsc.locadora.config.HibernateUtil;
import br.org.pucsc.locadora.model.User;
import br.org.pucsc.locadora.model.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author paulo
 */
public class UserDao {
 private org.hibernate.Session session;
     
    public User insert(User o) throws Exception {
        try {
            session = obtainSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return o;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public void update(User o) throws Exception {
        try {
            session = obtainSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public void delete(User o) throws Exception {
        try {
            session = obtainSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public User findById(Integer theId) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM User o WHERE o.id=:id");
            q.setString("id", theId.toString());
            User o = (User) q.uniqueResult();
            return o;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }
    
    public User findByEmail(String email) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM User o WHERE o.email=:email");
            q.setString("email", email);
            User o = (User) q.uniqueResult();
            return o;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }
    
    public List findByName(String value) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM User o WHERE o.name like :name");
            q.setString("name", "%"+value+"%");
            return q.list();
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public List findAll() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List lst = session.createQuery("from User").list();
            session.getTransaction().commit();
            return lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public List<User> list(Integer firstResult, Integer maxResults) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from User");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<User> lst = q.list();
            return lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }
    
    public Long countAll() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Long count = (Long) session.createQuery("select count(*) from User").uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }
    
    public User getNewEntity() {
        return new User();
    }

    protected Session obtainSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    protected void releaseSession(Session session) {
        // Do nothing...
    }
    
}
