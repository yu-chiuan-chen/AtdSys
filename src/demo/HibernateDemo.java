package demo;


import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateDemo {
	// Singleton pattern
	private static HibernateDemo hibernateDemo;

	private HibernateDemo() {}

	public static HibernateDemo getInstance() {
		if (hibernateDemo == null) {
			hibernateDemo = new HibernateDemo();
		}
		return hibernateDemo;
	}
	
	public void testHibernate() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		Session ss = sf.openSession();
		Transaction ts = ss.beginTransaction();
		TypedQuery<HibernateDemoVO> query = ss.createQuery(" SELECT friend_id FROM HibernateDemoVO WHERE mem_id = :mem_id ");
//		query.setParameter(0, 11000001);
		query.setParameter("mem_id", 11000001);
		List resultList = query.getResultList();
		Iterator iterator =  resultList.iterator();
		while(iterator.hasNext()) {
//			HibernateDemoVO vo = (HibernateDemoVO) iterator.next();
		    System.out.println("friend_id="+ iterator.next());
		}
		
	}
}
