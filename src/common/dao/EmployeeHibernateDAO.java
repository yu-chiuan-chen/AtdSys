package common.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import common.vo.DepartmentVO;

import common.utils.*;

import common.vo.EmployeeVO;

public class EmployeeHibernateDAO implements EmployeeDAO_interface {

	private static final String GET_ALL_STMT = "from EmployeeVO order by emp_no";

	@Override
	public void insert(EmployeeVO empVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(empVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(EmployeeVO empVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(empVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer emp_no) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			// 【此時多方(宜)可採用HQL刪除】
			// Query query = session.createQuery("delete employee where
			// empno=?");
			// query.setParameter(0, empno);
			// System.out.println("刪除的筆數=" + query.executeUpdate());

			// 【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			EmployeeVO empVO = new EmployeeVO();
			empVO.setEmp_no(emp_no);
			session.delete(empVO);

			// 【此時多方不可(不宜)採用cascade聯級刪除】
			// 【多方emp2.hbm.xml如果設為 cascade="all"或
			// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
			// EmployeeVO empVO = (EmployeeVO) session.get(EmployeeVO.class,
			// empno);
			// session.delete(empVO);

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public EmployeeVO findByPrimaryKey(Integer empno) {
		EmployeeVO empVO = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			empVO = (EmployeeVO) session.get(EmployeeVO.class, empno);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return empVO;
	}

	@Override
	public List<EmployeeVO> getAll() {
		List<EmployeeVO> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
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

	@Override
	public List<EmployeeVO> getAll(Map<String, String[]> map) {
		List<EmployeeVO> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			list = HibernateUtil_CompositeQuery_Emp2.getAllC(map);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public static void main(String[] args) {

		EmployeeHibernateDAO dao = new EmployeeHibernateDAO();

		// ● 新增
		DepartmentVO depVO = new DepartmentVO(); // 部門POJO
		depVO.setDep_no(2);

		// EmployeeVO empVO2 = new EmployeeVO();
		// empVO1.setName("吳01");
		// empVO1.setTitle("工程師");
		// empVO1.setFir_day(java.sql.Date.valueOf("2001-01-15"));
		// empVO1.setLas_day(null);
		// empVO1.setBirthday(java.sql.Date.valueOf("1990-01-15"));
		// empVO1.setPhoto(null);
		// empVO1.setEmail("abc01@aaa.com");
		// empVO1.setPsw("123132");
		// empVO1.setIs_mgr("1");
		// empVO1.setRemarks("無");
		// empVO1.setDepVO(depVO);
		// dao.insert(empVO1);

		// ● 修改
//		EmployeeVO empVO2 = new EmployeeVO();
//		empVO2.setName("吳02");
//		empVO2.setTitle("工程師");
//		empVO2.setFir_day(java.sql.Date.valueOf("2001-01-15"));
//		empVO2.setLas_day(null);
//		empVO2.setBirthday(java.sql.Date.valueOf("1990-01-15"));
//		empVO2.setPhoto(null);
//		empVO2.setEmail("abc01@aaa.com");
//		empVO2.setPsw("123132");
//		empVO2.setIs_mgr("1");
//		empVO2.setRemarks("無");
//		empVO2.setDepVO(depVO);
//		dao.insert(empVO2);

		// ● 刪除(小心cascade - 多方emp2.hbm.xml如果設為 cascade="all"或
//		 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除)
//		 dao.delete(11);

		// ● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
//		 EmployeeVO aEmp = dao.findByPrimaryKey(13);
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
//			System.out.print(aEmp.getDepVO().getDep_no() + ",");
//			System.out.print(aEmp.getDepVO().getName() + ",");
//			System.out.print(aEmp.getDepVO().getRemarks());
//			System.out.println();
//		 System.out.println("\n---------------------");

		// ● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
		List<EmployeeVO> list = dao.getAll();
		for (EmployeeVO aEmp : list) {
			System.out.print(aEmp.getEmp_no() + ",");
			System.out.print(aEmp.getName() + ",");
			System.out.print(aEmp.getTitle() + ",");
			System.out.print(aEmp.getFir_day() + ",");
			System.out.print(aEmp.getLas_day() + ",");
			System.out.print(aEmp.getBirthday() + ",");
			System.out.print(aEmp.getPhoto() + ",");
			System.out.print(aEmp.getEmail() + ",");
			System.out.print(aEmp.getPsw() + ",");
			System.out.print(aEmp.getIs_mgr() + ",");
			System.out.print(aEmp.getRemarks() + ",");
			System.out.print(aEmp.getDepVO().getDep_no() + ",");
			System.out.print(aEmp.getDepVO().getName() + ",");
			System.out.print(aEmp.getDepVO().getRemarks());
			System.out.println();
		}
	}
}

