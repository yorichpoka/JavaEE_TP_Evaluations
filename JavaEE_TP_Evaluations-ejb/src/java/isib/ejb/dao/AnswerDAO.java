/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isib.ejb.dao;

import isib.ejb.entity.Answer;
import java.util.List;
import isib.ejb.tools.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author POKA
 */
public class AnswerDAO implements IDAO<Answer> {

    private static final Logger log4j = Logger.getLogger(AnswerDAO.class);

    private Session session;    
    private Transaction transaction;    
    private String tableName = "Answer";
    
    @Override
    public Answer create(Answer obj) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            
            session.save(obj);
            
            transaction.commit();
        } 
        catch(Exception ex) 
        {
            transaction.rollback();
            log4j.error(ex);
            obj = null;
        }
        finally {
            session.close();
        }
        
        return obj;
    }

    @Override
    public Answer update(Answer obj) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            
            session.update(obj);
            
            transaction.commit();
        } 
        catch(Exception ex) 
        {
            transaction.rollback();
            log4j.error(ex);
            obj = null;
        }
        finally {
            session.close();
        }
        
        return obj;
    }

    @Override
    public boolean delete(int id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            
            session.delete(
                session.createQuery("from " + tableName + " where id = " + id).list().get(0)
            );
            
            transaction.commit();
        } 
        catch(Exception ex) 
        {
            transaction.rollback();
            log4j.error(ex);
        }
        finally {
            session.close();
            
            return get(id) == null;
        }
    }

    @Override
    public Answer get(int id) {
       Answer results = null;
       
       try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            
            results = (Answer)session.createQuery("from " + tableName + " where id = " + id).list().get(0);
            
            transaction.commit();
        } 
        catch(Exception ex) 
        {
            transaction.rollback();
            log4j.error(ex);
        }
        finally {
            session.close();
        }
        
        return results;
    }

    public List<Answer> getAllByQuestion(int id_question) {
       List<Answer> results = null;
       
       try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            
            results = session.createQuery("from " + tableName + " where id_question = " + id_question).list();
            
            transaction.commit();
        } 
        catch(HibernateException ex) 
        {
            transaction.rollback();
            log4j.error(ex);
        }
        finally {
            session.close();
        }
        
        return results;
    }

    @Override
    public List<Answer> getAll() {
       List<Answer> results = null;
       
       try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            
            results = session.createQuery("from " + tableName).list();
            
            transaction.commit();
        } 
        catch(Exception ex) 
        {
            transaction.rollback();
            log4j.error(ex);
        }
        finally {
            session.close();
        }
            
       return results;
    }

    @Override
    public Answer createWithRelation(Answer obj) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            
            session.save(obj.getQuestion());
            session.save(obj);
            
            transaction.commit();
        } 
        catch(Exception ex) 
        {
            transaction.rollback();
            log4j.error(ex);
            obj = null;
        }
        finally {
            session.close();
        }
        
        return obj;
    }
    
}
