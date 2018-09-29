package common.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public final void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("sessionFactory is set!!");
			HibernateUtil.sessionFactory = sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
