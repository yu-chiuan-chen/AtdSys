package common.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import common.vo.DepartmentVO;
import common.vo.EmpRelationVO;
import common.utils.HibernateUtil;

public class EmpRelationHibernateDAO implements EmpRelationDAO_interface {

	private static final String GET_ALL_STMT = "from EmpRelationVO order by emp_no";

	@Override
	public void insert(EmpRelationVO ERVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ERVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(EmpRelationVO ERVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ERVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(EmpRelationVO ERVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			// 【此時多方(宜)可採用HQL刪除】
			// Query query = session.createQuery("delete employee where
			// empno=?");
			// query.setParameter(0, empno);
			// System.out.println("刪除的筆數=" + query.executeUpdate());

			// 【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			session.delete(ERVO);

			// 【此時多方不可(不宜)採用cascade聯級刪除】
			// 【多方emp2.hbm.xml如果設為 cascade="all"或
			// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
			// EmpRelationVO ERVO = (EmpRelationVO)
			// session.get(EmpRelationVO.class,
			// empno);
			// session.delete(ERVO);

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public EmpRelationVO findByPrimaryKey(Integer empno) {
		EmpRelationVO ERVO = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ERVO = (EmpRelationVO) session.get(EmpRelationVO.class, empno);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return ERVO;
	}

	@Override
	public List<EmpRelationVO> getAll() {
		List<EmpRelationVO> list = null;
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
	public List<EmpRelationVO> getAll(Map<String, String[]> map) {
		List<EmpRelationVO> list = null;
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

	public static void main(String[] args) {

		EmpRelationHibernateDAO dao = new EmpRelationHibernateDAO();

		// ● 新增
		// EmpRelationVO ERVO2 = new EmpRelationVO();
		// ERVO2.setEmp_no(3);
		// ERVO2.setMgr_no(4);
		// ERVO2.setDir_mgr(1);
		// dao.insert(ERVO2);

		// ● 修改
		// EmpRelationVO ERVO2 = new EmpRelationVO();
		// ERVO2.setEmp_no(3);
		// ERVO2.setMgr_no(3);
		// ERVO2.setDir_mgr(2);
		// dao.insert(ERVO2);

		// ● 刪除(小心cascade - 多方emp2.hbm.xml如果設為 cascade="all"或
		// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除)
		EmpRelationVO ERVO2 = new EmpRelationVO();
		ERVO2.setEmp_no(3);
		ERVO2.setMgr_no(3);
		dao.delete(ERVO2);

		// ● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
		 EmpRelationVO aEmp = dao.findByPrimaryKey(13);
		 System.out.print(aEmp.getEmp_no() + ",");
//		 System.out.print(aEmp.getName() + ",");
//		 System.out.print(aEmp.getTitle() + ",");
		 System.out.println();
		 System.out.println("\n---------------------");

		// ● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
		// List<EmpRelationVO> list = dao.getAll();
		// for (EmpRelationVO aEmp : list) {
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
		// System.out.print(aEmp.getDepVO().getDep_no() + ",");
		// System.out.print(aEmp.getDepVO().getName() + ",");
		// System.out.print(aEmp.getDepVO().getRemarks());
		// System.out.println();
		// }
	}
}
