/*
 *  1. 萬用複合查詢-可由客戶端隨意增減任何想查詢的欄位
 *  2. 為了避免影響效能:
 *        所以動態產生萬用SQL的部份,本範例無意採用MetaData的方式,也只針對個別的Table自行視需要而個別製作之
 * */

package common.utils;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import common.utils.*;
import java.util.*;

import common.vo.*;

public class HibernateUtil_CompositeQuery_Emp2 {

	public static Criteria get_aCriteria_For_AnyDB(Criteria query, String columnName,String value) {
	
//		if ("empno".equals(columnName) || "deptno".equals(columnName))    //用於Integer
//			query.add(Restrictions.eq(columnName, new Integer(value)));    
//		else if ("sal".equals(columnName) || "comm".equals(columnName))   //用於Double
//			query.add(Restrictions.eq(columnName, new Double(value)));               
//		else if ("ename".equals(columnName) || "job".equals(columnName))  //用於varchar
//			query.add(Restrictions.like(columnName, "%"+value+"%"));
//		else if ("hiredate".equals(columnName))                           //用於date
//			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value)));
		
		if ("empno".equals(columnName))                                   //用於Integer
			query.add(Restrictions.eq(columnName, new Integer(value)));
		else if ("sal".equals(columnName) || "comm".equals(columnName))   //用於Double
			query.add(Restrictions.eq(columnName, new Double(value)));               
		else if ("ename".equals(columnName) || "job".equals(columnName))  //用於varchar
			query.add(Restrictions.like(columnName, "%"+value+"%"));
		else if ("hiredate".equals(columnName))                           //用於date
			query.add(Restrictions.eq(columnName, java.sql.Date.valueOf(value)));
		else if ("deptno".equals(columnName) ) {
			DepartmentVO depVO = new DepartmentVO();
			depVO.setDep_no(new Integer(value));
			query.add(Restrictions.eq("depVO", depVO));
		}
	
		return query;
	}

	public static List<EmployeeVO> getAllC(Map<String, String[]> map) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<EmployeeVO> list = null;
		try {
	
			Criteria query = session.createCriteria(EmployeeVO.class);
			Set<String> keys = map.keySet();
			int count = 0;
			
			for (String key : keys) {
				String value = map.get(key)[0];
				if (value!=null && value.trim().length()!=0 && !"action".equals(key)) {
					count++;					
					query = get_aCriteria_For_AnyDB(query, key, value);
					System.out.println("有送出查詢資料的欄位數count = " + count);
				}
			}
			
			query.addOrder( Order.asc("empno") );
			list = query.list();
			
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			throw ex; //System.out.println(ex.getMessage());
		} finally {
			session.close();
//			HibernateUtil.getSessionFactory().close();
		}
		
		return list;
	
	}

	public static void main(String argv[]) {

		// 配合 req.getParameterMap()方法 回傳 java.util.Map<java.lang.String,java.lang.String[]> 之測試
//		Map<String, String[]> map = new TreeMap<String, String[]>();
//		map.put("empno", new String[] { "7001" });
//		map.put("ename", new String[] { "KING" });
//		map.put("job", new String[] { "PRESIDENT" });
//		map.put("hiredate", new String[] { "1981-11-17" });
//		map.put("sal", new String[] { "5000.5" });
//		map.put("comm", new String[] { "0.0" });
//		map.put("deptno", new String[] { "10" });
//		map.put("action", new String[] { "getXXX" }); //注意Map裡面會含有action的key
		
//		List<EmployeeVO> list = getAllC(map);
//		for (EmployeeVO aEmp : list) {
//			System.out.print(aEmp.getEmp_no() + ",");
//			System.out.print(aEmp.getName() + ",");
//			System.out.print(aEmp.getTitle() + ",");
//			System.out.print(aEmp.getFir_day() + ",");
//			System.out.print(aEmp.getLas_day() + ",");
//			System.out.print(aEmp.getBirthday() + ",");
//			System.out.print(aEmp.getPhoto() + ",");
//			System.out.print(aEmp.getEmail() + ",");
//			System.out.print(aEmp.getPsw() + ",");
//			System.out.print(aEmp.getIs_mgr() + ",");
//			System.out.print(aEmp.getRemarks() + ",");
			// 注意以下三行的寫法 (優!)
//			System.out.print(aEmp.getDepVO().getNo() + ",");
//			System.out.print(aEmp.getDepVO().getName() + ",");
//			System.out.print(aEmp.getDepVO().getRemarks());
//			System.out.println();
//		}
	
	}
}
