/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.pucsc.locadora.dao;

import br.org.pucsc.locadora.config.HibernateUtil;
import br.org.pucsc.locadora.model.PrecoLocacao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author paulo
 */
public class PrecoLocacaoDao {

    private org.hibernate.Session session;

    public PrecoLocacao insert(PrecoLocacao o) throws Exception {
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

    public void update(PrecoLocacao o) throws Exception {
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

    public void delete(PrecoLocacao o) throws Exception {
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

    public PrecoLocacao findById(Integer theId) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM PrecoLocacao o WHERE o.id=:id");
            q.setString("id", theId.toString());
            PrecoLocacao o = (PrecoLocacao) q.uniqueResult();
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
            Query q = session.createQuery("FROM PrecoLocacao o WHERE o.nome like :nome");
            q.setString("nome", "%" + value + "%");
            return q.list();
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public List findByCategoria(Long idcategoria) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("FROM PrecoLocacao o WHERE o.idcategoria = :idcategoria");
            q.setString("idcategoria", idcategoria.toString());
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
            List lst = session.createQuery("from PrecoLocacao").list();
            session.getTransaction().commit();
            return lst;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public List<PrecoLocacao> list(Integer firstResult, Integer maxResults) throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from PrecoLocacao");
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResults);
            List<PrecoLocacao> lst = q.list();
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
            Long count = (Long) session.createQuery("select count(*) from PrecoLocacao").uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (HibernateException e) {
            throw new Exception(e.getCause().getMessage());
        } finally {
            releaseSession(session);
        }
    }

    public PrecoLocacao getNewEntity() {
        return new PrecoLocacao();
    }

    protected Session obtainSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    protected void releaseSession(Session session) {
        // Do nothing...
    }
}
