/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.pucsc.locadora.dao;

import br.org.pucsc.locadora.config.HibernateUtil;
import br.org.pucsc.locadora.model.Cliente;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author paulo
 */
public class ClienteDao {

    private org.hibernate.Session session;

    public Cliente insert(Cliente o) throws Exception {
        try {
            session = obtainSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return o;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public void update(Cliente o) throws Exception {
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

    public void delete(Cliente o) throws Exception {
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

    public Cliente findById(Integer theId) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM Cliente o WHERE o.id=:id");
            q.setString("id", theId.toString());
            Cliente o = (Cliente) q.uniqueResult();
            return o;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public List findByDescription(String value) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM Cliente o WHERE o.nome like :nome");
            q.setString("nome", "%" + value + "%");
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
            List lst = session.createQuery("from Cliente").list();
            session.getTransaction().commit();
            return lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public List<Cliente> list(Integer firstResult, Integer maxResults) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Cliente");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<Cliente> lst = q.list();
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
            Long count = (Long) session.createQuery("select count(*) from Cliente").uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public Cliente getNewEntity() {
        return new Cliente();
    }

    protected Session obtainSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    protected void releaseSession(Session session) {
        // Do nothing...
    }
}
