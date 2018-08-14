package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    /*
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
//            sessionFactory = new Configuration().configure("demo/HibernateDemo.hbm.xml").buildSessionFactory();
            
            ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
            sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    */

	public final void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("sessionFactory is set!!");
		HibernateUtil.sessionFactory = sessionFactory;
	}
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
