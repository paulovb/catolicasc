/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.pucsc.locadora.dao;

import br.org.pucsc.locadora.config.HibernateUtil;
import br.org.pucsc.locadora.model.Categoria;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author paulo
 */
public class CategoriaDao {
    
    private org.hibernate.Session session;
     
    public Categoria insert(Categoria o) throws Exception {
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

    public void update(Categoria o) throws Exception {
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

    public void delete(Categoria o) throws Exception {
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

    public Categoria findById(Integer id) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM Categoria o WHERE o.id=:id");
            q.setString("id", id.toString());
            Categoria o = (Categoria) q.uniqueResult();
            return o;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }
    
    public List findByNome(String value) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM Categoria o WHERE o.nome like :nome");
            q.setString("nome", "%"+value+"%");
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
            List lst = session.createQuery("from Categoria").list();
            session.getTransaction().commit();
            return lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public List<Categoria> list(Integer firstResult, Integer maxResults) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Categoria");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<Categoria> lst = q.list();
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
            Long count = (Long) session.createQuery("select count(*) from Categoria").uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }
    
    public Categoria getNewEntity() {
        return new Categoria();
    }

    protected Session obtainSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    protected void releaseSession(Session session) {
        // Do nothing...
    }
}
