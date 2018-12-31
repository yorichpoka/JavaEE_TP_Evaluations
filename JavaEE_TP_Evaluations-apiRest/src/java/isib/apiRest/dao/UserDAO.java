/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isib.apiRest.dao;

import isib.apiRest.entity.User;
import java.util.List;
import isib.apiRest.tools.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author POKA
 */
public class UserDAO implements IDAO<User> {

    private static final Logger log4j = Logger.getLogger(UserDAO.class);

    private Session session;    
    private Transaction transaction;    
    private String tableName = "User";
    
    @Override
    public User create(User obj) {
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
    public User update(User obj) {
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
    public User get(int id) {
       User results = null;
       
       try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            
            results = (User)session.createQuery("from " + tableName + " where id = " + id).list().get(0);
            
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
    public List<User> getAll() {
       List<User> results = null;
       
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
    public User createWithRelation(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public User get(String login, String password) {
       User results = null;
       
       try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            
            results = (User)session.createQuery("from " + tableName + " where login = '" + login + "' and password = '" + password + "'").list().get(0);
            
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
    
    public User get(String login, String password, boolean enabled) {
       User results = null;
       
       try {
            session = HibernateUtil.getSessionFactory().openSession();
            
            transaction = session.beginTransaction();
            
            results = (User)session.createQuery(
                            "from " + tableName + " where login = '" + login + "' and password = '" + password + "' and enabled = " + ((enabled) ? 1 : 0)
                        ).list().get(0);
            
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
}