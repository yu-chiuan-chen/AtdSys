package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.dao.DepartmentHibernateDAO;
import common.vo.DepartmentVO;
import user.service.EmployeeService;

public class HibernateDemo {
	// Singleton pattern
	private static HibernateDemo hibernateDemo;

	private HibernateDemo() {
	}

	public static HibernateDemo getInstance() {
		if (hibernateDemo == null) {
			hibernateDemo = new HibernateDemo();
		}
		return hibernateDemo;
	}

	public void testHibernate() {
		EmployeeService empService = new EmployeeService();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Path path=Paths.get("src/image/test.jpg");
			byte[] data = null;
			try {
				data=Files.readAllBytes(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empService.addEmp("測試gogo", "職員", sdf.parse("2018-10-10 10:10:10"), null, sdf.parse("1992-10-10 10:10:10"),
					data, "abc@gmail.com", "1111", "n", "無", 2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
