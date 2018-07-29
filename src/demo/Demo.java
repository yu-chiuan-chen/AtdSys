package demo;

public class Demo {
	// Now you see me!!!!!!??
	// SUCCESS!???
	
	public static void printHello(String name){
		System.out.println("Hello11111 "+name);
		System.out.println("Hello12332112345678 "+name);
	}
	
	public static void printHello2(String name){
		System.out.println("Hello "+name);
		System.out.println("Hello Hello Hello"+name);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello world!!");
		Demo.printHello("Amy!");
		
		// test Spring
		SpringDemo.getInstance().testSpring();
		// test Hibernate
		HibernateDemo.getInstance().testHibernate();
	}
	
}
