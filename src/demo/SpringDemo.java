package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {
	
	// Singleton pattern
	private static SpringDemo springDemo;
	
	private SpringDemo() {}
	
	public static SpringDemo getInstance() {
		if(springDemo == null) {
			springDemo = new SpringDemo();
		}
		return springDemo;
	}
	
	public void testSpring() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringDemoBean bean = (SpringDemoBean) ac.getBean("springDemoBean");
		System.out.println(String.format("Hello Spring, Hello %s", bean.getName()));
	}
	
}
