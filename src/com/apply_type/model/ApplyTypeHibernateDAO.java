package com.apply_type.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.apply_type.model.ApplyTypeDAO_interface;
import com.apply_type.model.ApplyTypeVO;
import com.employee.model.EmployeeVO;
import com.hibernate.util.HibernateUtil;

public class ApplyTypeHibernateDAO implements ApplyTypeDAO_interface {

	private static final String GET_ALL_STMT = "from ApplyTypeVO order by at_no";

	@Override
	public void insert(ApplyTypeVO ATVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ATVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(ApplyTypeVO ATVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ATVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer at_no) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ApplyTypeVO ApplyTypeVO = (ApplyTypeVO) session.get(ApplyTypeVO.class, at_no);
			session.delete(ApplyTypeVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}

	}

	@Override
	public ApplyTypeVO findByPrimaryKey(Integer at_no) {
		ApplyTypeVO ApplyTypeVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ApplyTypeVO = (ApplyTypeVO) session.get(ApplyTypeVO.class, at_no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return ApplyTypeVO;
	}

	@Override
	public List<ApplyTypeVO> getAll() {
		List<ApplyTypeVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

//	@Override
//	public Set<EmployeeVO> getEmpsByAtno(Integer at_no) {
//		Set<EmployeeVO> set = findByPrimaryKey(at_no).getEmps();
//		return set;
//	}

	public static void main(String[] args) {
		ApplyTypeHibernateDAO dao = new ApplyTypeHibernateDAO();

		// ● 新增-1(一方dept2.hbm.xml必須有cascade="save-update"
		// 或cascade="all"的設定)(雖然強大,不過實務上並不常用)(但,可用在訂單主檔與明細檔一次新增成功)
//		 ApplyTypeVO ATVO = new ApplyTypeVO(); // 部門POJO
//		 Set<EmployeeVO> set = new HashSet<EmployeeVO>();//
////		 準備置入員工數人,以便cascade="save-update"的測試
//		//
//		 EmployeeVO empXX = new EmployeeVO(); // 員工POJO1
//		 empXX.setName("吳15");
//		 empXX.setTitle("工程師");
//		 empXX.setFir_day(java.sql.Date.valueOf("2001-01-15"));
//		 empXX.setLas_day(null);
//		 empXX.setBirthday(java.sql.Date.valueOf("1990-01-15"));
//		 empXX.setPhoto(null);
//		 empXX.setEmail("abc15@aaa.com");
//		 empXX.setPsw("123132");
//		 empXX.setIs_mgr("1");
//		 empXX.setRemarks("無");
//		 empXX.setDepVO(ATVO);
//		//
//		 EmployeeVO empYY = new EmployeeVO(); // 員工POJO2
//		 empYY.setName("賴16");
//		 empYY.setTitle("工程師");
//		 empYY.setFir_day(java.sql.Date.valueOf("2001-01-15"));
//		 empYY.setLas_day(null);
//		 empYY.setBirthday(java.sql.Date.valueOf("1990-01-15"));
//		 empYY.setPhoto(null);
//		 empYY.setEmail("abc16@aaa.com");
//		 empYY.setPsw("123132");
//		 empYY.setIs_mgr("1");
//		 empYY.setRemarks("無");
//		 empYY.setDepVO(ATVO);
//		
//		 set.add(empXX);
//		 set.add(empYY);
//		
//		 ATVO.setName("php");
//		 ATVO.setRemarks("中國江西");
//		 ATVO.setEmps(set);
//		 dao.insert(ATVO);

//		// ● 修改-1(一方dept2.hbm.xml必須有cascade="save-update" 或
//		// cascade="all"的設定)(雖然強大,不過實務上並不常用)(但,可視情況使用之)
//		 ApplyTypeVO ATVO = new ApplyTypeVO(); // 部門POJO
//		 Set<EmployeeVO> set = new HashSet<EmployeeVO>(); //
//		// 準備置入員工數人,以便cascade="save-update"的測試
//		
//		 EmployeeVO empXX = new EmployeeVO(); // 員工POJO1
//		 empXX.setName("吳17");
//		 empXX.setTitle("工程師");
//		 empXX.setFir_day(java.sql.Date.valueOf("2001-01-15"));
//		 empXX.setLas_day(null);
//		 empXX.setBirthday(java.sql.Date.valueOf("1990-01-15"));
//		 empXX.setPhoto(null);
//		 empXX.setEmail("abc17@aaa.com");
//		 empXX.setPsw("123132");
//		 empXX.setIs_mgr("1");
//		 empXX.setRemarks("無");
//		 empXX.setDepVO(ATVO);
//		
//		 EmployeeVO empYY = new EmployeeVO(); // 員工POJO2
//		 empYY.setName("賴18");
//		 empYY.setTitle("工程師");
//		 empYY.setFir_day(java.sql.Date.valueOf("2001-01-15"));
//		 empYY.setLas_day(null);
//		 empYY.setBirthday(java.sql.Date.valueOf("1990-01-15"));
//		 empYY.setPhoto(null);
//		 empYY.setEmail("abc18@aaa.com");
//		 empYY.setPsw("123132");
//		 empYY.setIs_mgr("1");
//		 empYY.setRemarks("無");
//		 empYY.setATVO(ATVO);
//		
//		 set.add(empXX);
//		 set.add(empYY);
//		
//		 ATVO.setAt_no(3); // 【如果增加ApplyTypeVO.setDeptno(50); 則變成update】
//		 ATVO.setEmps(set);
//		 dao.update(ATVO);

		// ● 修改-2(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		 ApplyTypeVO ApplyTypeVO2 = new ApplyTypeVO(); // 部門POJO
//		 ApplyTypeVO2.setAt_no(3); // 【如果增加ApplyTypeVO.setDeptno(50);
////		 則變成update】
//		 ApplyTypeVO2.setName("婚嫁");
//		 ApplyTypeVO2.setRemarks("須附證明");
//		 dao.update(ApplyTypeVO2);

		// ●刪除 (超級強大!小心使用!)(一方dept2.hbm.xml必須有cascade="delete" 或
		// cascade="all"的設定, 再加上inverse="true"設定)
		// dao.delete(4);

//		// ● 新增-2(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		 ApplyTypeVO ApplyTypeVO = new ApplyTypeVO(); // 部門POJO
//		 ApplyTypeVO.setName("婚嫁");
//		 ApplyTypeVO.setRemarks("須附證明");
//		 dao.insert(ApplyTypeVO);

		// ● 查詢-findByPrimaryKey (優秀!) (一方dept2.hbm.xml必須設為lazy="false")
//		 ApplyTypeVO ApplyTypeVO3 = dao.findByPrimaryKey(1);
//		 System.out.print(ApplyTypeVO3.getAt_no() + ",");
//		 System.out.print(ApplyTypeVO3.getName() + ",");
//		 System.out.print(ApplyTypeVO3.getRemarks());
//		 System.out.println("\n-----------------");
		

		// ● 查詢-getAll-2 (優秀!!!) (一方dept2.hbm.xml必須設為lazy="false")
		List<ApplyTypeVO> list2 = dao.getAll();
		for (ApplyTypeVO aDept : list2) {
			System.out.print(aDept.getAt_no() + ",");
			System.out.print(aDept.getName() + ",");
			System.out.print(aDept.getRemarks());
			System.out.println("\n-----------------");
		
		}

	}

}
