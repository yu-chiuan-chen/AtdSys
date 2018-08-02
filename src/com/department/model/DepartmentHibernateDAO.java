package com.department.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.employee.model.EmployeeVO;
import com.hibernate.util.HibernateUtil;

public class DepartmentHibernateDAO implements DepartmentDAO_interface {

	private static final String GET_ALL_STMT = "from DepartmentVO order by dep_no";

	@Override
	public void insert(DepartmentVO depVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(depVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(DepartmentVO depVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(depVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer depno) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			DepartmentVO DepartmentVO = (DepartmentVO) session.get(DepartmentVO.class, depno);
			session.delete(DepartmentVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}

	}

	@Override
	public DepartmentVO findByPrimaryKey(Integer depno) {
		DepartmentVO DepartmentVO = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			DepartmentVO = (DepartmentVO) session.get(DepartmentVO.class, depno);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return DepartmentVO;
	}

	@Override
	public List<DepartmentVO> getAll() {
		List<DepartmentVO> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query<DepartmentVO> query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public Set<EmployeeVO> getEmpsByDeptno(Integer depno) {
		Set<EmployeeVO> set = findByPrimaryKey(depno).getEmps();
		return set;
	}

	public static void main(String[] args) {
		DepartmentHibernateDAO dao = new DepartmentHibernateDAO();

		// ● 新增-1(一方dept2.hbm.xml必須有cascade="save-update"
		// 或cascade="all"的設定)(雖然強大,不過實務上並不常用)(但,可用在訂單主檔與明細檔一次新增成功)
		// DepartmentVO depVO = new DepartmentVO(); // 部門POJO
		// Set<EmployeeVO> set = new HashSet<EmployeeVO>();//
		// 準備置入員工數人,以便cascade="save-update"的測試
		//
		// EmployeeVO empXX = new EmployeeVO(); // 員工POJO1
		// empXX.setName("吳15");
		// empXX.setTitle("工程師");
		// empXX.setFir_day(java.sql.Date.valueOf("2001-01-15"));
		// empXX.setLas_day(null);
		// empXX.setBirthday(java.sql.Date.valueOf("1990-01-15"));
		// empXX.setPhoto(null);
		// empXX.setEmail("abc15@aaa.com");
		// empXX.setPsw("123132");
		// empXX.setIs_mgr("1");
		// empXX.setRemarks("無");
		// empXX.setDepVO(depVO);
		//
		// EmployeeVO empYY = new EmployeeVO(); // 員工POJO2
		// empYY.setName("賴16");
		// empYY.setTitle("工程師");
		// empYY.setFir_day(java.sql.Date.valueOf("2001-01-15"));
		// empYY.setLas_day(null);
		// empYY.setBirthday(java.sql.Date.valueOf("1990-01-15"));
		// empYY.setPhoto(null);
		// empYY.setEmail("abc16@aaa.com");
		// empYY.setPsw("123132");
		// empYY.setIs_mgr("1");
		// empYY.setRemarks("無");
		// empYY.setDepVO(depVO);
		//
		// set.add(empXX);
		// set.add(empYY);
		//
		// depVO.setName("php");
		// depVO.setRemarks("中國江西");
		// depVO.setEmps(set);
		// dao.insert(depVO);

		// ● 修改-1(一方dept2.hbm.xml必須有cascade="save-update" 或
		// cascade="all"的設定)(雖然強大,不過實務上並不常用)(但,可視情況使用之)
		// DepartmentVO depVO = new DepartmentVO(); // 部門POJO
		// Set<EmployeeVO> set = new HashSet<EmployeeVO>(); //
		// 準備置入員工數人,以便cascade="save-update"的測試
		//
		// EmployeeVO empXX = new EmployeeVO(); // 員工POJO1
		// empXX.setName("吳17");
		// empXX.setTitle("工程師");
		// empXX.setFir_day(java.sql.Date.valueOf("2001-01-15"));
		// empXX.setLas_day(null);
		// empXX.setBirthday(java.sql.Date.valueOf("1990-01-15"));
		// empXX.setPhoto(null);
		// empXX.setEmail("abc17@aaa.com");
		// empXX.setPsw("123132");
		// empXX.setIs_mgr("1");
		// empXX.setRemarks("無");
		// empXX.setDepVO(depVO);
		//
		// EmployeeVO empYY = new EmployeeVO(); // 員工POJO2
		// empYY.setName("賴18");
		// empYY.setTitle("工程師");
		// empYY.setFir_day(java.sql.Date.valueOf("2001-01-15"));
		// empYY.setLas_day(null);
		// empYY.setBirthday(java.sql.Date.valueOf("1990-01-15"));
		// empYY.setPhoto(null);
		// empYY.setEmail("abc18@aaa.com");
		// empYY.setPsw("123132");
		// empYY.setIs_mgr("1");
		// empYY.setRemarks("無");
		// empYY.setDepVO(depVO);
		//
		// set.add(empXX);
		// set.add(empYY);
		//
		// depVO.setDep_no(3); // 【如果增加DepartmentVO.setDeptno(50); 則變成update】
		// depVO.setName("商務");
		// depVO.setRemarks("中國江西1");
		// depVO.setEmps(set);
		// dao.update(depVO);

		// ● 修改-2(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
		// DepartmentVO DepartmentVO2 = new DepartmentVO(); // 部門POJO
		// DepartmentVO2.setDep_no(3); // 【如果增加DepartmentVO.setDeptno(50);
		// 則變成update】
		// DepartmentVO2.setName("製造部2");
		// DepartmentVO2.setRemarks("中國江西2");
		// dao.update(DepartmentVO2);

		// ●刪除 (超級強大!小心使用!)(一方dept2.hbm.xml必須有cascade="delete" 或
		// cascade="all"的設定, 再加上inverse="true"設定)
		// dao.delete(4);

		// ● 新增-2(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
		// DepartmentVO DepartmentVO = new DepartmentVO(); // 部門POJO
		// DepartmentVO.setName("Java");
		// DepartmentVO.setRemarks("無");
		// dao.insert(DepartmentVO);

		// ● 查詢-findByPrimaryKey (優秀!) (一方dept2.hbm.xml必須設為lazy="false")
		// DepartmentVO DepartmentVO3 = dao.findByPrimaryKey(5);
		// System.out.print(DepartmentVO3.getDep_no() + ",");
		// System.out.print(DepartmentVO3.getName() + ",");
		// System.out.print(DepartmentVO3.getRemarks());
		// System.out.println("\n-----------------");
		// Set<EmployeeVO> set3 = DepartmentVO3.getEmps();
		// for (EmployeeVO aEmp : set3) {
		// System.out.print(aEmp.getEmp_no() + ",");
		// System.out.print(aEmp.getName() + ",");
		// System.out.print(aEmp.getTitle() + ",");
		// System.out.print(aEmp.getFir_day() + ",");
		// System.out.print(aEmp.getLas_day() + ",");
		// System.out.print(aEmp.getBirthday() + ",");
		// System.out.print(aEmp.getPhoto() + ",");
		// System.out.print(aEmp.getEmail() + ",");
		// System.out.print(aEmp.getPsw() + ",");
		// System.out.print(aEmp.getIs_mgr() + ",");
		// System.out.print(aEmp.getRemarks() + ",");
		// System.out.println();
		// }

		// ● 查詢-getAll-1 (一方dept2.hbm.xml不用設為lazy="false",因為沒用到多方的物件)
		// List<DepartmentVO> list1 = dao.getAll();
		// for (DepartmentVO aDept : list1) {
		// System.out.print(aDept.getDep_no() + ",");
		// System.out.print(aDept.getName() + ",");
		// System.out.print(aDept.getRemarks());
		// System.out.println();
		// }

		// ● 查詢-getAll-2 (優秀!!!) (一方dept2.hbm.xml必須設為lazy="false")
//		List<DepartmentVO> list2 = dao.getAll();
//		for (DepartmentVO aDept : list2) {
//			System.out.print(aDept.getDep_no() + ",");
//			System.out.print(aDept.getName() + ",");
//			System.out.print(aDept.getRemarks());
//			System.out.println("\n-----------------");
//			Set<EmployeeVO> set2 = aDept.getEmps();
//			for (EmployeeVO aEmp : set2) {
//				System.out.print(aEmp.getEmp_no() + ",");
//				System.out.print(aEmp.getName() + ",");
//				System.out.print(aEmp.getTitle() + ",");
//				System.out.print(aEmp.getFir_day() + ",");
//				System.out.print(aEmp.getLas_day() + ",");
//				System.out.print(aEmp.getBirthday() + ",");
//				System.out.print(aEmp.getPhoto() + ",");
//				System.out.print(aEmp.getEmail() + ",");
//				System.out.print(aEmp.getPsw() + ",");
//				System.out.print(aEmp.getIs_mgr() + ",");
//				System.out.print(aEmp.getRemarks() + ",");
//				System.out.print(aEmp.getDepVO().getDep_no() + ",");
//				System.out.print(aEmp.getDepVO().getName() + ",");
//				System.out.print(aEmp.getDepVO().getRemarks());
//				System.out.println();
//			}
//			System.out.println();
//		}

		// }
	}

}