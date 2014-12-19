package com.v3.utilities;

import javax.persistence.Entity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Volodimir Duda
 * 
 * Just for a reminder. Please realize that the session is statically initialized.
 * The Services which use this session never close the session. Thus, if we really 
 * wanted this Software to contain multi-user concurrency we would need to close 
 * and start new sessions.
 * </br>
 * As of now MySQL is smart enough to handle this concurrency. 
 */
@Entity
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
 
	public static void close() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
 
}
