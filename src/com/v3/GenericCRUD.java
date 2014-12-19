package com.v3;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.v3.utilities.HibernateUtil;

public class GenericCRUD <T>{
	
	private Session session;
	private Log log = LogFactory.getLog(GenericCRUD.class);
	
	public GenericCRUD(){
		openSession();
	}
	
	/**
	 * This method is already pre-intiatilized within the Constructor
	 */
	public void openSession(){
//		log.info("Opening Hibernate Session");
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	/**
	 * <b>REQUIRED CALL - When Finished.</b>
	 * Close the Session we are working with.
	 * 
	 */
	public void closeSession(){
//		log.info("Closing Hibernate Session");
		if(session.isConnected())
			session.close();
	}
	
	/**
	 * Checks to see if session is open.
	 * Will open new session if not open.
	 */
	private void isSessionOpen(){
		if(!session.isConnected()){
//			log.info("Found Closed Session: Opening new Session!");
			openSession();
		}
		//JOptionPane.showMessageDialog(null, "Current Session Active!");
	}
	
	public void evictSessionItem(T entity){
		session.evict(entity);
	}
	
	
	/**
	 * CREATE
	 * @param entity
	 */
	public boolean create(T entity){
		isSessionOpen();
		Transaction txn = null;
		boolean rv = false;
		log.info("Session pushing create()");
		try{
			txn = session.beginTransaction();
			session.save(entity);
			txn.commit();//commit pushes changes to Database
			rv = true;
		}catch(HibernateException e){
			//e.printStackTrace();
			txn.rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error Creating Item: " + e.getMessage());
			session.evict(entity);
			rv = false;
		}
//		closeSession();
		return rv;
	}
	
	/**
	 * UPDATE & MERGE so as to attach to session
	 * @param entity
	 */
	public void update(T entity){
		isSessionOpen();
		Transaction txn = null;
		log.info("Session pushing update()");
		try{
			txn = session.beginTransaction();
			session.merge(entity);
			txn.commit();
			
		}catch(HibernateException e){
			txn.rollback();
			JOptionPane.showMessageDialog(null, "Error" + e);
		}
//		closeSession();
	}
	
	/**
	 * DELETE -- In this method why don't we need to use merge()?
	 * 	I was under the impression that entity is considered detached.
	 * 	Find Answer for this question.
	 * @param entity
	 */
	public void delete(T entity){
		isSessionOpen();
		Transaction txn = null;
		log.info("Session pushing delete()");
		try{
			txn = session.beginTransaction();
			//session.merge(entity);
			session.delete(entity);
			txn.commit();
			
		}catch(HibernateException e){
			JOptionPane.showMessageDialog(null, "Error" + e);
			txn.rollback();
		}
//		closeSession();
	}
	
	//READING methods
	
	/**
	 * Its better to use this method versus findall(),
	 * This method allows for pagination and more in depth constraining.
	 * Use findall() for a simple and quick query to list all items.
	 * @param query, String representation of query
	 * @return List<T> of Entity objects.
	 */
	public List<T> findMany(Query queryCall){
		isSessionOpen();
		Transaction txn = null;
		List<T> t = null;
		log.info("Session pushing findMany()");
		try{
			txn = session.beginTransaction();
			//Query queryCall = session.createQuery(query);
			t = (List<T>) queryCall.list();
			txn.commit();
		}catch(HibernateException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			session.evict(t);
			txn.rollback();
		}
//		closeSession();
		return t;
	}


	public T findOne (Query queryCall){
		isSessionOpen();
		//JOptionPane.showMessageDialog(null, "We did our check");
		Transaction txn = null;
		T t = null;
		log.info("Session pushing findOne()");
		try{
			txn = session.beginTransaction();
			t = (T) queryCall.uniqueResult();
			txn.commit();
		}catch(HibernateException e){
			txn.rollback();
			JOptionPane.showMessageDialog(null, "Error" + e);
		}
		session.evict(t);
//		closeSession();
		return t;
		
	}
	
	public List<T> findAll(Class clazz){
		isSessionOpen();
		Transaction txn = null;
		List<T> t = null;
		log.info("Session pushing findAll()");
		try{
			txn = session.beginTransaction();
			t = (List<T>)session.createQuery("from "+ clazz.getName()).list();
			txn.commit();
			
		}catch(HibernateException e){
			e.printStackTrace();
			txn.rollback();
			JOptionPane.showMessageDialog(null, "Error" + e);
		}
//		closeSession();
		return t;
	}
	
	public T findByID(Class clazz, Integer id) {
		isSessionOpen();
		Transaction txn = null;
		T t = null;
		log.info("Session pushing findByID()");
		try{
			txn = session.beginTransaction();
			t = (T) session.get(clazz, id);
			txn.commit();
			
		}catch(HibernateException e){
			txn.rollback();
			JOptionPane.showMessageDialog(null, "Error" + e);
		}
//		closeSession();
		return t;
		
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		isSessionOpen();
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
